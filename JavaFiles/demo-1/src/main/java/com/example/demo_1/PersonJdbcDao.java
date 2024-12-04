package com.example.demo_1;
import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	static class PersonRowMapper implements RowMapper<Person>{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			
			return person;
		}
		
	}
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", id);
	}

	public int insert(Person person) {
        Object[] args = {person.getId(), person.getName(), person.getLocation()};

        return jdbcTemplate.update("insert into person (id, name, location) " + "values(?,  ?, ?)", args);
	}

	public int update(Person person) {
        Object[] args = { person.getName(), person.getLocation(), person.getId() };

        return jdbcTemplate.update("update person " + " set name = ?, location = ? " + " where id = ?", args);
	}

}
