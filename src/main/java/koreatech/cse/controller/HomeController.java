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

    @RequestMapping(value = "total/show" , method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Total> total(String search) throws InterruptedException {
        Total total = new Total();
        Result result = new Result();
        Items items = new Items();
        List<Item> itemList  = null;
        Item item = new Item();
        Authors authors = new Authors();
        List<Author> authorList = null;
        Author author = new Author();
        Publication publication = new Publication();
        Publisher publisher = new Publisher();
        Book book = new Book();
        Books books = new Books();
        List<Book> bookList = null;

        total.setKeyword(search);
        DbpiaItemTypes = dbpiaController.getDbpia(search);


        for(ItemType itemType : DbpiaItemTypes){
            HashSet<String> set = new HashSet<>();
            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            StringTokenizer st = new StringTokenizer(edit," ");
            while(st.hasMoreTokens()) {
                set.add(st.nextToken());
            }

            for(AuthorType authorType : itemType.getAuthors().getAuthor()){
                author.setUrl(authorType.getUrl());
                author.setOrder(authorType.getOrder());
                author.setName(authorType.getName());
                authorList.add(author);
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
                    System.out.println("naverItemTypes : " + naverItemTypes);
                    if (naverItemTypes != null) {
                        for (koreatech.cse.domain.naver.ItemType itemType1 : naverItemTypes) {
                            if (itemType1.getLink() == null || itemType1.getPrice() == null || itemType1 == null) {
                                break;
                            }
                            System.out.println("link : " + itemType1.getLink());
                            System.out.println("description : " + itemType1.getDescription());
                            System.out.println("Title : " + itemType1.getTitle());
                            System.out.println("Author : " + itemType1.getAuthor());
                            System.out.println("discout : " + itemType1.getDiscount());
                            System.out.println("Image : " + itemType1.getImage());
                            System.out.println("Isbn : " + itemType1.getIsbn());
                            System.out.println("Price : " + itemType1.getPrice());
                            System.out.println("Pubdate : " + itemType1.getPubdate());
                            System.out.println("Publisher : " + itemType1.getPublisher());

                            book.setAuthor(itemType1.getAuthor());
                            book.setDescription(itemType1.getDescription());
                            book.setDiscount(itemType1.getDiscount());
                            book.setImage(itemType1.getImage());
                            book.setIsbn(itemType1.getIsbn());
                            book.setLink(itemType1.getLink());
                            book.setPrice(itemType1.getPrice());
                            book.setPubdate(itemType1.getPubdate());
                            book.setPublisher(itemType1.getPublisher());
                            book.setTitle(itemType1.getTitle());
                            bookList.add(book);
                        }
                    }
                    System.out.println();
                }
            }
            books.setBooks(bookList);
            item.setBooks(books);
            itemList.add(item);
            items.setItems(itemList);
            result.setItems(items);
            total.setResult(result);
            set.clear();
        }
        return new ResponseEntity<Total>(total, HttpStatus.OK);
    }
}
