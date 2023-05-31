package Service;

import DAO.MemberDAO;
import JavaBean.Member;
import java.util.List;


public class MemberService {
    private MemberDAO memberDAO = new MemberDAO();

    public List<Member> selectAll() {
        List<Member> members = memberDAO.queryMulti("select * from member", Member.class);

        return members;
    }

    public Member getMemberById(int id) {
        Member member = memberDAO.queryRow("SELECT * FROM member WHERE `id`= ?", Member.class, id);

        return member;
    }

    public Boolean add(Member member) {

        String username = member.getUsername();
        String password = member.getPassword();
        String sex = member.getSex();
        String tel = member.getTel();
        String email = member.getEmail();

        int row = memberDAO.update("  INSERT INTO `member` (`username`,`password`,`sex`,`tel`,`email`) VALUES (?,MD5(?),?,?,?)", username,password,sex,tel,email );

        return row > 0;

    }

    public Boolean checkUsername(String username) {
        Member member = memberDAO.queryRow("SELECT * FROM member WHERE `username`= ?", Member.class, username);

        return member == null;

    }

    public Member checkUid(String uid01,String uid02) {

        Member member = memberDAO.queryRow("SELECT * FROM `member` WHERE uid01 = ? AND uid02= ?", Member.class, uid01,uid02);

        return member ;

    }

    public Member checkLogIn(String username, String password) {
        Member member = memberDAO.queryRow("SELECT * FROM `member` WHERE `username`= ? AND `password`= MD5(?)", Member.class, username, password);
        return member;
    }
    public Boolean setUid(String uid01,String uid02,int id){
        int row = memberDAO.update("UPDATE `member` SET uid01=? , uid02=? WHERE id=?", uid01, uid02, id);
        return row>0;
    }

    public Boolean setUserstate(int userstate,int id){
        int row = memberDAO.update("UPDATE `member` SET userState = ? WHERE `id` = ?", userstate, id);
        return row>0;
    }
}
