package com.team1.travel.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team1.travel.model.UserDao;
import com.team1.travel.model.UserVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserVo login(String userEmail, String userPw) {
        UserVo user = userDao.findByEmail(userEmail);
        if (user != null) {
            String storedPassword = userDao.getPasswordByEmail(userEmail);
            if (passwordEncoder.matches(userPw, storedPassword)) {
                return user; // 로그인 성공
            }
        }
        return null; // 로그인 실패
    }
    
    public void add(UserVo bean) {
        bean.setUserPw(passwordEncoder.encode(bean.getUserPw())); // 비밀번호 암호화
        userDao.addInfo(bean);
    }
    
    // 중복 이메일 확인
    public boolean isEmailAvailable(String userEmail) {
        int count = userDao.countByEmail(userEmail);
        return count == 0; // 이메일이 존재하지 않으면 true 반환
    }
}
