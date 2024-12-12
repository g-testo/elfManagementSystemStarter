package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.ElfDao;
import org.yearup.models.Elf;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MySqlElfDao extends MySqlDaoBase implements ElfDao {
    private DataSource dataSource;

    @Autowired
    public MySqlElfDao(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public Elf getById(int id) {
        String query = "SELECT * FROM elves WHERE elf_id=?;";

        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, id);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                if(resultSet.next()){
                    return mapElf(resultSet);
                }
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Elf> getAll() {
        return null;
    }

    @Override
    public Elf create(Elf elf) {
        return null;
    }

    @Override
    public void update(int id, Elf elf) {

    }

    @Override
    public void delete(int id) {

    }

    private Elf mapElf(ResultSet resultSet) throws SQLException {
        int elfId = resultSet.getInt("elf_id");
        String name = resultSet.getString("name");
        String imageUrl = resultSet.getString("image_url");
        int elfRank = resultSet.getInt("elf_rank");
        int roleId = resultSet.getInt("role_id");
        return new Elf(elfId, name, imageUrl, elfRank, roleId);
    }
}
