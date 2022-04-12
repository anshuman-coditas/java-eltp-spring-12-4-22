package Dao;

import com.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {
    HibernateTemplate ht;


    public HibernateTemplate getHt() {
        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }

    @Transactional
public int insert(Student student){
        ht.setCheckWriteOperations(false);


//        ht.getSessionFactory().openSession().beginTransaction();
        Integer i= (Integer) ht.save(student);
//        ht.getSessionFactory().getCurrentSession().getTransaction().commit();
        return i;
}
@Transactional
public int update(String name,int sid){
        return ht.bulkUpdate("update Student set name='"+name+"' where id='"+sid+"'");

}
public List<Student> fetch(){
        return ht.loadAll(Student.class);

    }
    @Transactional
public int delete(int sid){
        return ht.bulkUpdate("delete from Student where id=?0",sid);

}
}
