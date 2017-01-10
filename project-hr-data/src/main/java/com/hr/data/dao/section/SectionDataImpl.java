package com.hr.data.dao.section;

import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.Section.SECTION;
import com.hr.jooq.tables.pojos.Section;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class SectionDataImpl implements SectionDataApi{

    @Override
    public List<Section> getSectionList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Section> into = create.select(SECTION.SECTION_ID, SECTION.SECTION_NAME, SECTION.DESCRIPTION)
                    .from(SECTION)
                    .where(SECTION.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Section.class);
            log.debug("Section list = {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Section> getSectionById(int sectionId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Section> into = create.select(SECTION.SECTION_ID, SECTION.SECTION_NAME, SECTION.DESCRIPTION)
                    .from(SECTION)
                    .where(SECTION.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(SECTION.SECTION_ID.eq(sectionId)))
                    .fetch().into(Section.class);
            log.debug("Section id = {} : {}" ,sectionId , into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
}
