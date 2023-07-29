package poling_app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class controller {
	
	@RequestMapping("/")
	public String hello()
	{
		return "Hello poling";
	}
	
	Configuration con=new Configuration().configure().addAnnotatedClass(Admin.class);
	SessionFactory sf=con.buildSessionFactory();
	Session session=sf.openSession();

	@RequestMapping(method=RequestMethod.POST,value="/adminsignup")
	public boolean signup(@RequestBody Admin obj)
	{		Transaction tx=session.beginTransaction();
		 session.save(obj);
		 tx.commit();
		 
		 return true;
		
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/adminlogin")
	public boolean login(@RequestBody Admin obj)
	{	
		 
		Admin o=(Admin)session.get(Admin.class, obj.getEmail());
		if(o==null)
			return false;
		if(obj.getPassword().equals(o.getPassword())&&obj.getEmail().equals(o.getEmail()))
			return true;
		return false;
		
	}
	
	Configuration can=new Configuration().configure().addAnnotatedClass(candidate.class);
	SessionFactory sff=can.buildSessionFactory();
	Session candidate=sff.openSession();
	
	@RequestMapping(method=RequestMethod.POST,value="/candidatesignup")
	public boolean signup(@RequestBody candidate obj)
	{		Transaction tx=candidate.beginTransaction();
		 candidate.save(obj);
		 tx.commit();
		 
		 return true;
		
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/candidatelogin")
	public boolean login(@RequestBody candidate obj)
	{	
		 
		candidate o=(candidate)candidate.get(candidate.class, obj.getEmail());
		if(o==null)
			return false;
		if(obj.getPassword().equals(o.getPassword())&&obj.getEmail().equals(o.getEmail()))
			return true;
		return false;
		
	}
	
	Configuration n=new Configuration().configure().addAnnotatedClass(poll.class);
	SessionFactory f=n.buildSessionFactory();
	Session poll=f.openSession();
	@RequestMapping("/vote")
	public List<poll> vote()
	{	Criteria criteria =poll.createCriteria(poll.class);
		return (List<poll>)criteria.list();
	}
	Configuration p=new Configuration().configure().addAnnotatedClass(participant.class);
	SessionFactory pp=p.buildSessionFactory();
	Session par=pp.openSession();
	@RequestMapping(method=RequestMethod.POST,value="/cast")
	public boolean cast(@RequestBody vote cand)
	{	if(cand==null)
			return false;
		participant o=(participant)par.get(participant.class, cand.getCand());
		o.setVotes(o.getVotes()+1);
		Transaction tx=par.beginTransaction();
		par.update(o);
		tx.commit();
		
		
		return true;
	}
	@RequestMapping(method=RequestMethod.POST,value="/poll")
	public boolean nup(@RequestBody poll obj)
	{		Transaction tx=poll.beginTransaction();
		 poll.save(obj);
		 tx.commit();
		
		 
		 for(String n:obj.getCandidates())
		 {	Transaction t=par.beginTransaction();
			 participant r=new participant();
			 
			 r.setElection(obj.getName());
			 r.setName(n);
			 r.setVotes(0);
			 par.save(r);
			 t.commit();
			 
		 }
		 return true;
		
		
	}
	
	
	
	
	
	@RequestMapping("/getelection/{email}")
	public List<poll> g(@PathVariable String email )
	{	Criteria criteria=poll.createCriteria(poll.class);
		criteria.add(Restrictions.eq("adminname", email));
		
		return (List<poll>)criteria.list();
		
	}
	
	@RequestMapping("/result/{election}")
	public List<participant> getresult(@PathVariable String election)
	{
		Criteria parcriteria=par.createCriteria(participant.class);

		parcriteria.add(Restrictions.eq("election",election));
		
		return (List<participant>)parcriteria.list();
		
		
	}
	
	
	
	
	
	
	
}
