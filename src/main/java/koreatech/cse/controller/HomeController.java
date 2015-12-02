package koreatech.cse.controller;

import koreatech.cse.controller.dbpia.DbpiaController;
import koreatech.cse.controller.naver.NaverController;
import koreatech.cse.domain.dbpia.AuthorType;
import koreatech.cse.domain.dbpia.ItemType;
import koreatech.cse.domain.total.*;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

@Controller
@RequestMapping("/")
public class HomeController extends Thread {

    @Value("${datapath}")
    private String datapath;

    StringSimilarity stringSimilarity = new StringSimilarity();
    DbpiaController dbpiaController = new DbpiaController();
    NaverController naverController = new NaverController();


    List<koreatech.cse.domain.naver.ItemType> naverItemTypes = null;
    List<ItemType> DbpiaItemTypes;

    @RequestMapping("/")
    public String home()
    {
        return "index";
    }



    @Value("${env.text}")
    private String env;

    @RequestMapping("/total")
    public String search(){
        return "total";
    }

    @RequestMapping(value = "total/show/json" , method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public ResponseEntity<Total> total(@RequestParam(value = "search", required = true) String search,@RequestParam(value = "display", required = false, defaultValue = "3") int display) throws InterruptedException {
        if(display < 0)
            display = 1;
        if(display > 100)
            display = 100;
        System.out.println("display : " + display);
        Total total = new Total();
        Result result = new Result();
        Items items = new Items();
        List<Item> itemList  = new ArrayList<>();
        total.setKeyword(search);
        DbpiaItemTypes = dbpiaController.getDbpia(search);


        for(ItemType itemType : DbpiaItemTypes){
            Authors authors = new Authors();
            List<Author> authorList = new ArrayList<>();
            HashSet<String> set = new HashSet<>();


            Item item = new Item();
            Author author = new Author();
            Publication publication = new Publication();
            Publisher publisher = new Publisher();
            Book book = new Book();
            Books books = new Books();
            List<Book> bookList = new ArrayList<>();

            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            System.out.println("datapath : " + datapath);
            Komoran komoran = new Komoran(datapath);
            List<List<Pair<String,String>>> result2 = komoran.analyze(edit);
            for (List<Pair<String, String>> eojeolResult : result2) {
                for (Pair<String, String> wordMorph : eojeolResult) {
                    set.add(wordMorph.getFirst());
                }
                System.out.println();
            }

            for(AuthorType authorType : itemType.getAuthors().getAuthor()){
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

            System.out.println("집합 : " + set);
            for(String str : set) {
                if (str.length() > 2) {
                    System.out.println("검색어 : " + str);
                    naverItemTypes = naverController.getNaver(str,display);
                    //System.out.println("naverItemTypes : " + naverItemTypes);
                    if (naverItemTypes != null) {
                        for (koreatech.cse.domain.naver.ItemType itemType1 : naverItemTypes) {
                            if (itemType1.getLink() == null || itemType1.getPrice() == null || itemType1 == null) {
                                break;
                            }
                            bookList.add(new Book(itemType1.getTitle(),itemType1.getLink(),itemType1.getImage(),itemType1.getAuthor(),itemType1.getPrice(),itemType1.getDiscount(),itemType1.getPublisher()
                                            ,itemType1.getPubdate(),itemType1.getIsbn(),itemType1.getDescription()));
                        }
                    }
//                    System.out.println();
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
        return new ResponseEntity<Total>(total, HttpStatus.OK);
    }

    @RequestMapping(value = "total/show/xml" , method = RequestMethod.GET, produces="application/xml;charset=UTF-8")
    public ResponseEntity<Total> totalXML(@RequestParam(value = "search", required = true) String search,@RequestParam(value = "display", required = false, defaultValue = "3") int display) throws InterruptedException {

        if(display < 0)
            display = 1;
        if(display > 100)
            display = 100;
        System.out.println("display : " + display);
        Total total = new Total();
        Result result = new Result();
        Items items = new Items();
        List<Item> itemList  = new ArrayList<>();
        total.setKeyword(search);
        DbpiaItemTypes = dbpiaController.getDbpia(search);


        for(ItemType itemType : DbpiaItemTypes){
            Authors authors = new Authors();
            List<Author> authorList = new ArrayList<>();
            HashSet<String> set = new HashSet<>();


            Item item = new Item();
            Author author = new Author();
            Publication publication = new Publication();
            Publisher publisher = new Publisher();
            Book book = new Book();
            Books books = new Books();
            List<Book> bookList = new ArrayList<>();

            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            System.out.println("datapath : " + datapath);
            Komoran komoran = new Komoran(datapath);
            List<List<Pair<String,String>>> result2 = komoran.analyze(edit);
            for (List<Pair<String, String>> eojeolResult : result2) {
                for (Pair<String, String> wordMorph : eojeolResult) {
                    set.add(wordMorph.getFirst());
                }
                System.out.println();
            }

            for(AuthorType authorType : itemType.getAuthors().getAuthor()){
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

            System.out.println("집합 : " + set);
            for(String str : set) {
                if (str.length() > 2) {
                    System.out.println("검색어 : " + str);
                    naverItemTypes = naverController.getNaver(str,display);
                    //System.out.println("naverItemTypes : " + naverItemTypes);
                    if (naverItemTypes != null) {
                        for (koreatech.cse.domain.naver.ItemType itemType1 : naverItemTypes) {
                            if (itemType1.getLink() == null || itemType1.getPrice() == null || itemType1 == null) {
                                break;
                            }
                            bookList.add(new Book(itemType1.getTitle(),itemType1.getLink(),itemType1.getImage(),itemType1.getAuthor(),itemType1.getPrice(),itemType1.getDiscount(),itemType1.getPublisher()
                                    ,itemType1.getPubdate(),itemType1.getIsbn(),itemType1.getDescription()));
                        }
                    }
//                    System.out.println();
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
        return new ResponseEntity<Total>(total, HttpStatus.OK);
    }
}
