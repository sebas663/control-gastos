package com.control.gastos;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.control.gastos.dtos.MasterBoxDiscountDTO;
import com.control.gastos.dtos.MasterCompanyDTO;
import com.control.gastos.dtos.MasterCreditCardDiscountDTO;
import com.control.gastos.dtos.MasterProductDTO;
import com.control.gastos.dtos.TicketDTO;
import com.control.gastos.entities.MasterBoxDiscount;
import com.control.gastos.entities.MasterCompany;
import com.control.gastos.entities.MasterCreditCardDiscount;
import com.control.gastos.entities.MasterProduct;
import com.control.gastos.entities.Ticket;
import com.control.gastos.jpa.repository.BaseRepository;
import com.control.gastos.jpa.repository.interfaces.IBaseRepository;
import com.control.gastos.services.MasterBoxDiscountService;
import com.control.gastos.services.MasterCompanyService;
import com.control.gastos.services.MasterCreditCardDiscountService;
import com.control.gastos.services.MasterProductService;
import com.control.gastos.services.TicketService;
import com.control.gastos.services.interfaces.IMasterBoxDiscountService;
import com.control.gastos.services.interfaces.IMasterCompanyService;
import com.control.gastos.services.interfaces.IMasterCreditCardDiscountService;
import com.control.gastos.services.interfaces.IMasterProductService;
import com.control.gastos.services.interfaces.ITicketService;

@SpringBootApplication
@ComponentScan
@Import({PersistenceContext.class})
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ControlGastosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlGastosApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("http://localhost:63342")
    			.allowedMethods("GET","POST","PUT", "DELETE")
    			.allowedHeaders("Content-Type")
    			.exposedHeaders("Content-Type")
    			.allowCredentials(false).maxAge(3600);;
            }
        };
    }
	 @Bean(name = "org.dozer.Mapper")
	  public DozerBeanMapper dozerBean() {
//	    List<String> mappingFiles = Arrays.asList(
//	      "dozer-global-configuration.xml", 
//	      "dozer-bean-mappings.xml",
//	      "more-dozer-bean-mappings.xml"
//	    );

	    DozerBeanMapper dozerBean = new DozerBeanMapper();
//	    dozerBean.setMappingFiles(mappingFiles);
	    return dozerBean;
	  }
	@Bean(name="masterBoxDiscountService")
    public IMasterBoxDiscountService masterBoxDiscountService(){
        return new MasterBoxDiscountService(MasterBoxDiscount.class, MasterBoxDiscountDTO.class, baseRepository("com.control.gastos.entities.Ticket"));
    }
	@Bean(name="masterCompanyService")
    public IMasterCompanyService masterCompanyService(){
        return new MasterCompanyService(MasterCompany.class, MasterCompanyDTO.class, baseRepository("com.control.gastos.entities.Ticket"));
    }
	@Bean(name="masterCreditCardDiscountService")
    public IMasterCreditCardDiscountService masterCreditCardDiscountService(){
        return new MasterCreditCardDiscountService(MasterCreditCardDiscount.class, MasterCreditCardDiscountDTO.class, baseRepository("com.control.gastos.entities.Ticket"));
    }
	@Bean(name="masterProductService")
    public IMasterProductService masterProductService(){
        return new MasterProductService(MasterProduct.class, MasterProductDTO.class, baseRepository("com.control.gastos.entities.Ticket"));
    }
	@Bean(name="ticketService")
    public ITicketService ticketService(){
        return new TicketService(Ticket.class, TicketDTO.class, baseRepository("com.control.gastos.entities.Ticket"));
    }
    /**
     * 
     * @param className
     * @return
     */
	public IBaseRepository baseRepository(String className){
    	BaseRepository baseRepository = null;
    	try {
			Class<?> act = Class.forName(className);
			baseRepository = new BaseRepository(act, null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return baseRepository;
    }
   
}
