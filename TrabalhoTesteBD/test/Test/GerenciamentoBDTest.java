package Test;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class GerenciamentoBDTest {
    
    private final Logger logger = Logger.getLogger(this.getClass());
    
    @Test
    public void criarTabelas() {
        
        logger.info("Criando tabelas.");
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