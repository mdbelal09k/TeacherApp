package com.HibernateWithORM;

import org.hibernate.Session;

import com.HibernateWithORM.Util.HibernateUtil;
import com.HibernateWithORM.entity.Student;

import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
        System.out.println( "Hello World!" );
        
        ///-> CREATE A NEW STUDENT
        
        Student student =new Student((long) 1, "sam altman","samaltman@gmail.com");
        ///->s save student
        
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaction =(Transaction) session.beginTransaction();
        if(transaction !=null) {
        	session.persist(student);
        }else {
        	System.out.println("student not added!");
        }
        transaction.commit();
        session.close();
        
        System.out.println("student saved: "+student);
        HibernateUtil.shotdown();
    }
}
