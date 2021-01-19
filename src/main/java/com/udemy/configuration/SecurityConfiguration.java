package com.udemy.configuration;

 

//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter
public class SecurityConfiguration  
{
	
//	@Autowired
//	@Qualifier("userService")
//	private UserDetailsService userService;
//	
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//	}
//	
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception { 
//		
//		http.authorizeRequests()
//		    .antMatchers("/css/*","/imgs/*").permitAll()
//		    .and()
//		    .formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
//		    .usernameParameter("username").passwordParameter("password")
//		    .defaultSuccessUrl("/loginsuccess").permitAll()
//		    .and()
//		    .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll(); //para que se carguen los recursos estaticos
//	 	}
//
//	
	
	
}
