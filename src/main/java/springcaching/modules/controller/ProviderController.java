package springcaching.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcaching.modules.entities.Provider;
import springcaching.modules.service.ProviderService;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    ProviderService providerService;

    /**
     * 查询列表
     * @return 列表
     */
    @GetMapping("/providers")
    public List<Provider> list(){
        List<Provider> list=providerService.getAll();
        return list;
    }


    /**
     * 查看一条数据
     * @param pid 主键ID
     * @return
     * */
    @GetMapping("/provider/{pid}")
    public Provider provider(@PathVariable("pid") Integer pid){
        Provider p = providerService.provider(pid);
        return p;
    }


    /**
     * 修改操作
     * @return
     */
    @GetMapping("/pro/{pid}")
    public String update(@PathVariable("pid") Integer pid){

        Provider provider = new Provider();
        provider.setPid(pid);
        provider.setProviderName("修改名字1");
        provider.setPhone("123456789");
        providerService.save(provider);
        return provider.toString();

    }

    /**
     * 创建操作
     * @return
     */
    @GetMapping("/provider/add")
    public String add() {

        Provider provider = new Provider();
        provider.setProviderName("增加名字1");
        provider.setPhone("456");
        providerService.add(provider);

        return provider.toString();
    }

    /**
     * 删除操作
     * @param
     * @return
     */
    @GetMapping("/prodel/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        if(pid>0){
            providerService.delete(pid);
        }
        return "删除成功";
    }


}
