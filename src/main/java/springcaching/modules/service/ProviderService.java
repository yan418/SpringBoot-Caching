package springcaching.modules.service;

import springcaching.modules.entities.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getAll();

    Provider provider(Integer pid);

    void save(Provider provider);

    void add(Provider provider);

    void delete(Integer pid);

}
