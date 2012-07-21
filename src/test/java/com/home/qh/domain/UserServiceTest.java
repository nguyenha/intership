package com.home.qh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService = new UserService();

	@Mock
	private UserRepository userRepositoryMock;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldInitializeWithOneDemoUser() {
		// act
		userService.initialize();
		// assert
		verify(userRepositoryMock, times(1)).save(any(User.class));
	}

	@Test
	public void shouldThrowExceptionWhenUserNotFound() {
		// arrange
		thrown.expect(UsernameNotFoundException.class);
		thrown.expectMessage("user not found");

		when(userRepositoryMock.findByUsername("user")).thenReturn(null);
		// act
		userService.loadUserByUsername("user");
	}

	//@Test
	public void shouldReturnUserDetails() {
		// arrange
		User demoUser = new User("user", "demo", "ROLE_USER");
		when(userRepositoryMock.findByUsername("user1")).thenReturn(demoUser);

		// act
		UserDetails userDetails = userService.loadUserByUsername("user");
		
		System.out.println("userDetails: " + userDetails);

		// assert
		assertEquals(demoUser.getUsername(), userDetails.getUsername());
		assertEquals(demoUser.getPassword(), userDetails.getPassword());
		assertTrue(hasAuthority(userDetails, demoUser.getRole()));
	}

	@Test
	public void iterator_will_return_hello_world(){
		//arrange
		Iterator i=mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		//act
		String result=i.next()+" "+i.next();
		System.out.println("result: " + result);
		//assert
		assertEquals("Hello World", result);
	}
	
	private boolean hasAuthority(UserDetails userDetails, String role) {
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		for(GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals(role)) {
				return true;
			}
		}
		return false;
	}
}