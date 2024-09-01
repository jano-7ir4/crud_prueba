package cl.bigbytes.foodapp.repository;

import cl.bigbytes.foodapp.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Item save(Item item) {
        String sql;

        if (item.getId() == null) {
            sql = "INSERT INTO item (id,name, description, price) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql,item.getId(), item.getName(), item.getDescription(), item.getPrice());
        } else {
            sql = "UPDATE item SET name = ?, description = ?, price = ? WHERE id = ?";
            jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice(), item.getId());
        }
        return item;
    }


    public Item getItem(Integer id) {
        String sql = "SELECT * FROM item WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setDescription(rs.getString("description"));
            item.setPrice(rs.getDouble("price"));
            return item;
        });
    }

    public void deleteItem(Integer id) {
        String sql = "DELETE FROM item WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
