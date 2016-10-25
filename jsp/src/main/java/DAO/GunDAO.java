package DAO;

import models.Gun;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by wopqw on 25.10.16.
 */
public interface GunDAO {

    Collection<Gun> getAll();

    default Optional<Gun> getById(long id){
        return getAll().stream()
                .filter(g -> g.getId() == id)
                .findAny();
    }
}
