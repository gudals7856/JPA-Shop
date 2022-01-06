package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)  // 메모리 모드까지 적용해서 DB랑 연동하기 위해 spring이랑 함께 실행
@SpringBootTest // 없으면 Autowired 실패함
@Transactional  // 롤백을 위해
public class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    EntityManager em;
    
    @Test
    public void 상품_등록() throws Exception {
        //given
        Book book = new Book();
        book.setAuthor("kim");
        
        //when
        Long savedId = itemService.saveItem(book);

        //then
        em.flush();
        assertEquals(book, itemRepository.findOne(savedId));

    }
}