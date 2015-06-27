package Test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class GerenciamentoBDTest {
    
    @Test
    public void criarTabelas() {
        
        Configuration config = new Configuration();
        config.configure();
        new SchemaExport(config).create(true, true);
        
    }
    
//    @Test
//    public void apagarTabelas() {
//        
//        logger.info("Apagando tabelas.");
//        Configuration config = new Configuration();
//        config.configure();
//        new SchemaExport(config).drop(true, true);
//        
//    }
    
}