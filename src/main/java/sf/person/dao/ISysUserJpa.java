package sf.person.dao;

import sf.person.vo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISysUserJpa extends JpaRepository<SysUser,Long>{
}
