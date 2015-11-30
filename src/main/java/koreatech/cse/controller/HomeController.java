package koreatech.cse.controller;

import koreatech.cse.controller.dbpia.DbpiaController;
import koreatech.cse.controller.naver.NaverController;
import koreatech.cse.domain.dbpia.AuthorType;
import koreatech.cse.domain.dbpia.ItemType;
import koreatech.cse.domain.total.*;
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
    StringSimilarity stringSimilarity = new StringSimilarity();
    DbpiaController dbpiaController = new DbpiaController();
    NaverController naverController = new NaverController();


    List<koreatech.cse.domain.naver.ItemType> naverItemTypes = null;
    List<ItemType> DbpiaItemTypes;

    @RequestMapping("/")
    public String home()
    {
        return "hello";
    }



    @Value("${env.text}")
    private String env;

    @RequestMapping("/total")
    public String search(){
        return "total";
    }

    @RequestMapping(value = "total/show" , method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public ResponseEntity<Total> total(String search) throws InterruptedException {
        Total total = new Total();
        Result result = new Result();
        Items items = new Items();
        List<Item> itemList  = new ArrayList<>();
        Item item = new Item();

        List<Author> authorList = new ArrayList<>();
        Author author = new Author();
        Publication publication = new Publication();
        Publisher publisher = new Publisher();
        Book book = new Book();
        Books books = new Books();
        List<Book> bookList = new ArrayList<>();

        total.setKeyword(search);
        DbpiaItemTypes = dbpiaController.getDbpia(search);


        for(ItemType itemType : DbpiaItemTypes){
            Authors authors = new Authors();
            HashSet<String> set = new HashSet<>();
            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            StringTokenizer st = new StringTokenizer(edit," ");
            while(st.hasMoreTokens()) {
                set.add(st.nextToken());
            }

            for(AuthorType authorType : itemType.getAuthors().getAuthor()){
                author.setName(authorType.getName());
                author.setOrder(authorType.getOrder());
                author.setUrl(authorType.getUrl());
                authorList.add(author);
                //authorList.add(new Author(authorType.getOrder(), authorType.getName(), authorType.getUrl()));
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
                    naverItemTypes = naverController.getNaver(str);
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
            System.out.println("booklist : " + bookList.size());
            books.setBooks(bookList);
            System.out.println("books : " + books);
            item.setBooks(books);
            itemList.add(item);
            items.setItems(itemList);
            System.out.println("itemList : " + itemList);


            authorList.clear();
            bookList.clear();
            itemList.clear();
            result.setItems(items);
            total.setResult(result);
            set.clear();
        }
        return new ResponseEntity<Total>(total, HttpStatus.OK);
    }
}
