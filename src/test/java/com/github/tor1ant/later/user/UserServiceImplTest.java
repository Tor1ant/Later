package com.github.tor1ant.later.user;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Transactional
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@WebMvcTest(controllers = UserController.class)
class UserServiceImplTest {

    @MockBean
    private UserService userService;

    private UserRepository repository;
    @Autowired
    MockMvc mockMvc;

/*    @Test
    @DisplayName("Тестирование метода getAllUsers")
    void getAllUsers() {
        User user = new User();
        user.setEmail("312@mail.ru");
        user.setState(UserState.ACTIVE);
        user.setFirstName("Толя");
        user.setLastName("Антипов");
        repository.save(user);
        List<User> users = repository.findAll();
        assertThat(user, equalTo(users.get(0)));
        assertThat(users, hasItem(user));
        assertThat(users, allOf(hasSize(1), notNullValue()));
    }*/

    @Test
    @DisplayName("Тестирование метода getAllUsers без Spring")
    void getAllUsersWIthMockMVC() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setEmail("312@mail.ru");
        userDto.setState(UserState.ACTIVE);
        userDto.setFirstName("Толя");
        userDto.setLastName("Антипов");

        Mockito.when(userService.getAllUsers()).thenReturn(List.of(userDto));
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.is(1)))
                .andExpect(jsonPath("$[0].id", Matchers.is(1)));
    }
}