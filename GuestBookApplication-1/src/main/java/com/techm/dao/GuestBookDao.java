package com.techm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techm.bean.Entry;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@Transactional
@Repository
public class GuestBookDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Entry p) {
		String sql = "insert into guest_book(text, imagepath, status) values('" + p.getTextentry() + "','" + p.getImagepath()
				+ "', 'P')";
		return template.update(sql);
	}

	public int approve(int id) {
		String sql = "update guest_book set status='A' where id=" + id + "";
		return template.update(sql);
	}

	public int reject(int id) {
		String sql = "update guest_book set status='R' where id= " + id + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from guest_book where id=" + id + "";
		return template.update(sql);
	}

	public List<Entry> getEntries() {
		return template.query("select * from guest_book where status = 'P'", new RowMapper<Entry>() {
			public Entry mapRow(ResultSet rs, int row) throws SQLException {
				Entry e = new Entry();
				e.setId(rs.getInt(1));
				e.setTextentry(rs.getString(2));
				e.setImagepath(rs.getString(3));
				e.setStatus(rs.getString(4));
				return e;
			}
		});
	}
	
	public List<Entry> getAREntries() {
		return template.query("select * from guest_book where status != 'P'", new RowMapper<Entry>() {
			public Entry mapRow(ResultSet rs, int row) throws SQLException {
				Entry e = new Entry();
				System.out.print(rs.getInt(1));
				e.setId(rs.getInt(1));
				System.out.print(rs.getString(2));
				e.setTextentry(rs.getString(2));
				System.out.print(rs.getString(3));
				e.setImagepath(rs.getString(3));
				System.out.print(rs.getString(4));
				e.setStatus(rs.getString(4));
				return e;
			}
		});
	}
}