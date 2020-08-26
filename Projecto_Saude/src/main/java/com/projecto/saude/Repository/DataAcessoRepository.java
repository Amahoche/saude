
package com.projecto.saude.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.DataAcesso;
@Repository

public interface DataAcessoRepository extends JpaRepository<DataAcesso, Long>{

}
