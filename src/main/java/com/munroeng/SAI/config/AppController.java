package com.munroeng.SAI.config;
////Application controller for SAI program for Munro ENgineering
////Written by Connor McLean
//
//package com.munroeng.SAI;
////import java.util.List;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//
//import com.munroeng.SAI.DAO.MachineDAO;
//import com.munroeng.SAI.models.Machine;
//
//public class AppController {
//
//	public static void main(String[] args) {
//		
//		//Create application context from applicationContext file contained in resources folder
//		//Uses <prop key="hibernate.hbm2ddl.auto">update</prop> to create/update tables
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
//
//
//		
////		MachineDAO MachineDAO = context.getBean(MachineDAO.class);
////		
////		Machine Machine = new Machine("Drophammer", "Telesett", 700);
//		
////		MachineDAO.save(Machine);
////		
////		System.out.println("Machine::"+ Machine);
//		
////		List<Machine> list = MachineDAO.list();
//		
////		for(Machine p : list){
////			System.out.println("Machine List::"+p);
////		}
//		//close resources
////		context.close();	
//	}
//	
//	   @Bean
//	   public HibernateTransactionManager getTransactionManager() {
//	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//	      transactionManager.setSessionFactory(getSessionFactory().getObject());
//	      return transactionManager;
//	   }
//}
