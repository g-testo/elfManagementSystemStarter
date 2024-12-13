package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.ElfDao;
import org.yearup.models.Elf;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlElfDao extends MySqlDaoBase implements ElfDao {
    private DataSource dataSource;

    @Autowired
    public MySqlElfDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Elf getById(int id) {
        String query = "SELECT * FROM elves WHERE elf_id=?;";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                if (resultSet.next()) {
                    return mapElf(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Elf> getAll() {
        String query = "SELECT * FROM elves";
        List<Elf> elves = new ArrayList<>();

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while(resultSet.next()){
                Elf elf = mapElf(resultSet);

                elves.add(elf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return elves;
    }

    @Override
    public Elf create(Elf elf) {
        String query = "INSERT INTO elves(`name`, `image_url`, `elf_rank`, `role_id`) VALUES(?,?,?,?);";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, elf.getName());
            preparedStatement.setString(2, elf.getImageUrl());
            preparedStatement.setInt(3, elf.getElfRank());
            preparedStatement.setInt(4, elf.getRoleId());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                try (
                        ResultSet resultSet = preparedStatement.getGeneratedKeys()
                ) {
                    if (resultSet.next()) {
                        int newlyGeneratedId = resultSet.getInt(1);
                        elf.setElfId(newlyGeneratedId);
                        return elf;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, Elf elf) {
        String query = "UPDATE elves SET name=?, image_url=?, elf_rank=?, role_id=? WHERE elf_id=?;";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, elf.getName());
            preparedStatement.setString(2, elf.getImageUrl());
            preparedStatement.setInt(3, elf.getElfRank());
            preparedStatement.setInt(4, elf.getRoleId());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE from elves WHERE elf_id=?";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
