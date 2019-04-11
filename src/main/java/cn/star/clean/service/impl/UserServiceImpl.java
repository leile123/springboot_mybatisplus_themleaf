package cn.star.clean.service.impl;


import cn.star.clean.entity.User;
import cn.star.clean.mapper.UserMapper;
import cn.star.clean.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-03-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements
    IUserService {

}
