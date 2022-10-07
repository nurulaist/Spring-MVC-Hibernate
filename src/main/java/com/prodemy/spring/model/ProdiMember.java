package com.prodemy.spring.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODI_MEMBER")
public class ProdiMember implements Serializable{
	private static final long serialVersionUID = -8442804834286052948L;
	
	@Id
	@Column(name = "pr_id")
	private int prid;
	
	@Id
	@Column(name = "mhs_id")
	private int mhsid;

	public int getPrid() {
		return prid;
	}
	

	public void setPrid(int prid) {
		this.prid = prid;
	}

	public int getMhsid() {
		return mhsid;
	}

	public void setMhsid(int mhsid) {
		this.mhsid = mhsid;
	}

	@Override
	public String toString() {
		return "ProdiMember [prid=" + prid + ", mhsid=" + mhsid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(mhsid, prid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ProdiMember)) {
			return false;
		}
		ProdiMember other = (ProdiMember) obj;
		return mhsid == other.mhsid && prid == other.prid;
	}
	
	
}
	