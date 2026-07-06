package com.example.spring.springtheory.ch05.ex_5_4.service;

import com.example.spring.springtheory.ch05.ex_5_4.dao.Level;
import com.example.spring.springtheory.ch05.ex_5_4.dao.UserDAO;
import com.example.spring.springtheory.ch05.ex_5_4.domain.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    private UserDAO userDAO;
    private MailSender mailSender;

    public UserServiceImpl(UserDAO userDAO, MailSender mailSender) {
        this.userDAO = userDAO;
        this.mailSender = mailSender;
    }

    // 신규가입
    @Override
    public void add(User user) throws SQLException, ClassNotFoundException {
        user.setLevel( Level.BASIC );
        userDAO.add(user);
    }

    // 업그레이드 담당
    @Override
    public void upgradeLevels() {
        try {
            List<User> users = userDAO.getAll();
            for ( User user : users ) {
                if ( canUpgrade(user) ) {
                    upgradeLevel(user);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("레벨 업그레이드 중 오류가 발생해 롤백했습니다.", e);
        }

    }

    // '올릴 수 있는가'
    private boolean canUpgrade(User user) {
        Level curLevel = user.getLevel();
        switch (curLevel) {
            case BASIC:
                return user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER;
            case SILVER:
                return user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD;
            case GOLD:
                return false;
            default:
                throw new IllegalStateException("Unexpected value: " + curLevel);
        }
    }

    // 실제 업그레드
    protected void upgradeLevel(User user) throws SQLException, ClassNotFoundException {
        user.upgradeLevel();
        userDAO.update(user);
        sendUpgradeEmail(user);
    }

    // '메일을 만들어 보낸다'까지만 한다. '어떻게 실제로 보내는가'는 주입된 mailSender에 맡긴다.
    private void sendUpgradeEmail(User user) {
        // User에 email 필드가 없으므로 예시로 id를 주소처럼 사용한다(실무라면 user.getEmail()).
        Mail mail = new Mail(
                user.getId(),
                "[안내] 등급이 업그레이드되었습니다",
                user.getName() + "님의 등급이 " + user.getLevel() + " 로 변경되었습니다."
        );
        mailSender.send(mail);
    }

}