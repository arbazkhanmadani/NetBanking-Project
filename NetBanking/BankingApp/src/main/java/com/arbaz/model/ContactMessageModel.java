package com.arbaz.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.arbaz.ctl.ContactCtl;
import com.arbaz.dto.ContactDto;


public class ContactMessageModel {
	Connection con = ConnectionProvider.getConnectivity();

	public boolean validateContactMessage(ContactDto dto) {
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into contactmessage values(?,?,?,?)");
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getMobile());
			ps.setString(4, dto.getMessage());
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
