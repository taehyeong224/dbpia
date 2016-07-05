package koreatech.cse.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import koreatech.cse.controller.StringSimilarity;
import koreatech.cse.controller.daum.DaumController;
import koreatech.cse.controller.dbpia.DbpiaController;

import koreatech.cse.domain.User;
import koreatech.cse.domain.dbpia.AuthorType;

import koreatech.cse.domain.dbpia.ItemType;
import koreatech.cse.domain.total.Author;
import koreatech.cse.domain.total.Authors;
import koreatech.cse.domain.total.Book;
import koreatech.cse.domain.total.Books;
import koreatech.cse.domain.total.Item;
import koreatech.cse.domain.total.Items;
import koreatech.cse.domain.total.Publication;
import koreatech.cse.domain.total.Publisher;
import koreatech.cse.domain.total.Result;
import koreatech.cse.domain.total.Total;
import koreatech.cse.service.UserService;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping(value={"/"})
public class HomeController
        extends Thread {
    @Inject
    private UserService userService;
    @Value(value="${datapath}")
    private String datapath;
    StringSimilarity stringSimilarity = new StringSimilarity();
    DbpiaController dbpiaController = new DbpiaController();
    DaumController daumController = new DaumController();
    List<koreatech.cse.domain.daum.Item> daumItem = null;
    List<koreatech.cse.domain.dbpia.ItemType> DbpiaItemTypes;
    @Value(value="${env.text}")
    private String env;

    @RequestMapping(value={"/"})
    public String home() {
        return "index";
    }

    @RequestMapping(value={"/error"})
    public String error() {
        return "/error";
    }

    @RequestMapping(value={"/total"})
    public String search() {
        return "total";
    }

    @RequestMapping(value={"total/show/json"}, method={RequestMethod.GET}, produces={"application/json;charset=UTF-8"})
    public ResponseEntity<Total> total(@RequestParam(value="key", required=true) String key, @RequestParam(value="search", required=true) String search, HttpServletResponse response) throws InterruptedException, IOException {
        User user = this.userService.getKey(key);
        System.out.println("user : " + user);
        if (user == null) {
            response.sendRedirect("http://kth409.synology.me/wsc/error");
            return null;
        }
        System.out.println("key : " + key);
        Total total = new Total();
        Result result = new Result();
        Items items = new Items();
        ArrayList<Item> itemList = new ArrayList<Item>();
        total.setKeyword(search);
        this.DbpiaItemTypes = this.dbpiaController.getDbpia(search);
        for (koreatech.cse.domain.dbpia.ItemType itemType : this.DbpiaItemTypes) {
            Authors authors = new Authors();
            ArrayList<Author> authorList = new ArrayList<Author>();
            HashSet<String> set = new HashSet<String>();
            Item item = new Item();
            Author author = new Author();
            Publication publication = new Publication();
            Publisher publisher = new Publisher();
            Book book = new Book();
            Books books = new Books();
            ArrayList<Book> bookList = new ArrayList<Book>();
            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            System.out.println("datapath : " + this.datapath);
            Komoran komoran = new Komoran(this.datapath);
            List<List<Pair<String,String>>> result2 = komoran.analyze(edit);
            for (List<Pair<String, String>> eojeolResult : result2) {
                for (Pair<String, String> wordMorph : eojeolResult) {
                    set.add(wordMorph.getFirst());
                }
                System.out.println();
            }
            for (AuthorType authorType : itemType.getAuthors().getAuthor()) {
                authorList.add(new Author(authorType.getOrder(), authorType.getName(), authorType.getUrl()));
                System.out.println("authorList  : " + authorList);
            }
            authors.setAuthors(authorList);
            item.setAuthors(authors);
            item.setTitle(itemType.getTitle());
            item.setCtype(itemType.getCtype());
            item.setLink_api(itemType.getLinkApi());
            item.setLink_url(itemType.getLinkUrl());
            item.setPages(itemType.getPages());
            item.setPreview(itemType.getPreview());
            publication.setIssn(itemType.getPublication().getIssn());
            publication.setName(itemType.getPublication().getName());
            publication.setUrl(itemType.getPublication().getUrl());
            item.setPublication(publication);
            publisher.setUrl(itemType.getPublisher().getUrl());
            publisher.setName(itemType.getPublisher().getName());
            item.setPublisher(publisher);
            System.out.println("\uc9d1\ud569 : " + set);
            for (String str : set) {
                if (str.length() <= 2) continue;
                System.out.println("\uac80\uc0c9\uc5b4 : " + str);
                this.daumItem = this.daumController.getDaum(str);
                if (this.daumItem == null) continue;
                for (koreatech.cse.domain.daum.Item item1: this.daumItem) {
                    if (item1.getAuthor() == null || item1.getTitle() == null) break;
                    bookList.add(new Book(item1.getAuthor_t(),item1.getSale_price(),item1.getCover_s_url(),item1.getSale_yn(),
                            item1.getPub_date(),item1.getLink(),item1.getBarcode(),item1.getEtc_author(),item1.getStatus_des(),
                            item1.getAuthor(),item1.getTitle(),item1.getCategory(),item1.getPub_nm(),item1.getTranslator(),item1.getDescription(),
                            item1.getIsbn(), item1.getEbook_barcode(),item1.getIsbn13(),item1.getList_price(),item1.getCover_l_url()));
                }
            }
            books.setBook(bookList);
            item.setBooks(books);
            itemList.add(item);
            items.setItem(itemList);
            set.clear();
        }
        result.setItems(items);
        total.setResult(result);
        return new ResponseEntity(total, HttpStatus.OK);
    }

    @RequestMapping(value={"/total/show/xml"}, method={RequestMethod.GET}, produces={"application/xml;charset=UTF-8"})
    public ResponseEntity<Total> totalXML(@RequestParam(value="key", required=true) String key, @RequestParam(value="search", required=true) String search, HttpServletResponse response) throws InterruptedException, IOException {
        User user = this.userService.getKey(key);
        System.out.println("user : " + user);
        if (user == null) {
            response.sendRedirect("http://kth409.synology.me/wsc/error");
            return null;
        }

        Total total = new Total();
        Result result = new Result();
        Items items = new Items();
        ArrayList<Item> itemList = new ArrayList<Item>();
        total.setKeyword(search);
        this.DbpiaItemTypes = this.dbpiaController.getDbpia(search);
        for (koreatech.cse.domain.dbpia.ItemType itemType : this.DbpiaItemTypes) {
            Authors authors = new Authors();
            ArrayList<Author> authorList = new ArrayList<Author>();
            HashSet<String> set = new HashSet<>();
            Item item = new Item();
            Author author = new Author();
            Publication publication = new Publication();
            Publisher publisher = new Publisher();
            Book book = new Book();
            Books books = new Books();
            ArrayList<Book> bookList = new ArrayList<Book>();
            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            System.out.println("datapath : " + this.datapath);
            Komoran komoran = new Komoran(this.datapath);
            List<List<Pair<String,String>>> result2 = komoran.analyze(edit);
            for (List<Pair<String, String>> eojeolResult : result2) {
                for (Pair<String, String> wordMorph : eojeolResult) {
                    set.add(wordMorph.getFirst());
                }
                System.out.println();
            }
            for (AuthorType authorType : itemType.getAuthors().getAuthor()) {
                authorList.add(new Author(authorType.getOrder(), authorType.getName(), authorType.getUrl()));
                System.out.println("authorList  : " + authorList);
            }
            authors.setAuthors(authorList);
            item.setAuthors(authors);
            item.setTitle(itemType.getTitle());
            item.setCtype(itemType.getCtype());
            item.setLink_api(itemType.getLinkApi());
            item.setLink_url(itemType.getLinkUrl());
            item.setPages(itemType.getPages());
            item.setPreview(itemType.getPreview());
            publication.setIssn(itemType.getPublication().getIssn());
            publication.setName(itemType.getPublication().getName());
            publication.setUrl(itemType.getPublication().getUrl());
            item.setPublication(publication);
            publisher.setUrl(itemType.getPublisher().getUrl());
            publisher.setName(itemType.getPublisher().getName());
            item.setPublisher(publisher);
            System.out.println("\uc9d1\ud569 : " + set);
            for (String str : set) {
                if (str.length() <= 2) continue;
                System.out.println("\uac80\uc0c9\uc5b4 : " + str);
                this.daumItem = this.daumController.getDaum(str);
                if (this.daumItem == null) continue;
                for (koreatech.cse.domain.daum.Item item1: this.daumItem) {
                    if (item1.getAuthor() == null || item1.getTitle() == null) break;
                    bookList.add(new Book(item1.getAuthor_t(),item1.getSale_price(),item1.getCover_s_url(),item1.getSale_yn(),
                            item1.getPub_date(),item1.getLink(),item1.getBarcode(),item1.getEtc_author(),item1.getStatus_des(),
                            item1.getAuthor(),item1.getTitle(),item1.getCategory(),item1.getPub_nm(),item1.getTranslator(),item1.getDescription(),
                            item1.getIsbn(), item1.getEbook_barcode(),item1.getIsbn13(),item1.getList_price(),item1.getCover_l_url()));
                }
            }
            books.setBook(bookList);
            item.setBooks(books);
            itemList.add(item);
            items.setItem(itemList);
            set.clear();
        }
        result.setItems(items);
        total.setResult(result);
        return new ResponseEntity(total, HttpStatus.OK);
    }
}