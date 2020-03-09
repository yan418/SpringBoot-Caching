package springcaching.modules.dao;

import springcaching.modules.entities.Provider;

import java.util.List;

public interface ProviderDao {

    List<Provider> getProviders();

    Provider getProviderByPid(Integer pid);

    int updateProvider(Provider provider);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

}
