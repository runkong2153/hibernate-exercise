package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.Insert;

import core.util.HibernateUtil;
import web.member.pojo.Member;

public class TestApp {

	public static void main(String[] args) {

		Class<Member> clazz = Member.class;

		TestApp app = new TestApp();
		Member member = new Member();
		// Test Case
		member.setId(1);
		member.setPass(false);
		System.out.println();

	}

	public Integer insert(Member member) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.persist(member);
			transaction.commit();
			return member.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public int deletById(Integer id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Member member = session.get(Member.class, id);

			session.remove(member);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}
	}

//	public int deletById(Member newMember) {有錯還沒改好
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Member member = session.get(Member.class, id);
//
//			// 若有傳pass 就將此pass設定給oldMember
//			final Boolean pass = newMember.getPass();
//			if (pass != null) {
//				oldMember.setPass(pass);
//			}
//			// 若有傳roleId，就將此roleId設定給oldMember
//			final Integer roled = newMember.getPass();
//			if (roled != null) {
//				oldMember.setPass(roled);
//			}
//			session.remove(member);
//			transaction.commit();
//			return 1;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return -1;
//		}
//	}

	public Member selectById(Integer id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Member member = session.get(Member.class, id);
			transaction.commit();
			return member;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	
	public int updateById(Member newMember){
        SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
        Session session =sessionFactory.openSession();
        try {
            Transaction txn=session.beginTransaction();
            Member member =session.get(Member.class,newMember.getId());
            if(newMember.getRoleId()!=null)
                member.setRoleId(newMember.getId());
            System.out.println(newMember.getPassword());
            if(newMember.getPassword()!=null)
                member.setPassword(newMember.getPassword());
            txn.commit();
            return 1;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return -1;

    }
 

//	public static void main(String[] args) {		//查詢
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	Session session = sessionFactory.openSession();
//	Member member = session.get(Member.class, 1);
//	System.out.println(member.getNickname());
//	HibernateUtil.shutdown();
//}

//public static void main(String[] args) {		//新增
//	Member member = new Member();
//	member.setUsername("使用者名稱");
//	member.setPassword("密碼");
//	member.setNickname("暱稱");
//	
//	TestApp app = new TestApp();
//	app.insert(member);
//	System.out.println(member.getId());
//}
//
//public static void main(String[] args) {		//刪除
//	TestApp app = new TestApp();
//	System.out.println(app.deletById(3));
//}
}
