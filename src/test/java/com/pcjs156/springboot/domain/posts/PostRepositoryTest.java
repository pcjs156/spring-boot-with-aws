package com.pcjs156.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정이 없을 경우 H2 DB를 자동 사용
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    // 단위 테스트가 끝날 때마다 수행되는 메서드
    @After
    public void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // Given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // Insert(Update) 쿼리 실행
        postRepository.save(Posts.builder()
                .title(title).content(content).author("qkrdbqls1001@gmail.com").build());

        // When
        // posts 테이블에 저장된 모든 데이터를 조회
        List<Posts> postsList = postRepository.findAll();

        // Then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

        assertThat(postsList.size()).isEqualTo(1);
    }
}
