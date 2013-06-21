package freemarker.play;

public enum ShipMethod {
	Ground('G', "G", "Ground"),
	SecondDay('2', "G2", "2nd Day"),
	Overnight('O', "GO", "Overnight"),
	PriorityOvernight('P', "OP", "Priority Overnight");

	private char id;
	private String code;
	private String description;
	
	ShipMethod(char id, String code, String description) {
		this.id = id;
		this.code = code;
		this.description = description;
	}
	public static ShipMethod lookup(char id) {
		for (ShipMethod sm : values()){
			if (sm.getId() == id) {
				return sm;
			}
		}
		return Ground;
	}
	

	/**
	 * @return the id
	 */
	public char getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(char id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
