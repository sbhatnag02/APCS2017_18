package net.mrpaul.PB050.ps12;

public class Person implements Comparable<Person>{

	//Initialize instance vars
	private String lastName, firstName;
	private String emailAddress;
	private String userName;
	private int numFriends;
	
	/**
	 * Constructor for Person. Sets all crucial information to memory (through instance vars)
	 * @param lastName Last Name of Person
	 * @param firstName First Name of Person
	 * @param emailAddress Email Address
	 * @param userName User Name
	 * @param numFriends Number of Friends
	 */
	public Person(String lastName, String firstName, String emailAddress, String userName, int numFriends) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.userName = userName;
		this.numFriends = numFriends;
	}
	
	/**
	 * Default Constructor for person. Initializes all String instance vars to "" and numFriends to 0
	 */
	public Person() {
		this.lastName = "";
		this.firstName = "";
		this.emailAddress = "";
		this.userName = "";
		this.numFriends = 0;
	}

	
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the numFriends
	 */
	public int getNumFriends() {
		return numFriends;
	}

	/**
	 * @param numFriends the numFriends to set
	 */
	public void setNumFriends(int numFriends) {
		this.numFriends = numFriends;
	}
	

	@Override
	/**
	 * Override compareTo method from Object. Determines whether or not 2 person objects have the same characteristics
	 * @param other Person to compare to
	 */
	public int compareTo(Person other) {
		//Check for illegal argument exception
		if(other == null) {
			throw new IllegalArgumentException("Other Person is null");
		}else {
			//Compare last name
			if(this.lastName.compareTo(other.getLastName()) < 0) {
				return -1;
			}else if(this.lastName.compareTo(other.getLastName()) > 0) {
				return 1;
			}
			//Compate first name
			if(this.firstName.compareTo(other.getFirstName()) < 0) {
				return -1;
			}else if(this.lastName.compareTo(other.getFirstName()) > 0) {
				return 1;
			}
			//Compare email address
			if(this.emailAddress.compareTo(other.getEmailAddress()) < 0) {
				return -1;
			}else if(this.emailAddress.compareTo(other.getEmailAddress()) > 0) {
				return 1;
			}
			//Compare user name
			if(this.userName.compareTo(other.getUserName()) < 0) {
				return -1;
			}else if(this.userName.compareTo(other.getUserName()) > 0) {
				return 1;
			}
			//Compare number of friends
			if(this.numFriends < other.getNumFriends()) {
				return -1;
			}else if(this.numFriends > other.getNumFriends()) {
				return 1;
			}
			//Return 0 if characteristics are identical
			return 0;	
		}
	}
	/**
	 * Override equals method from Java Object
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			if(!this.lastName.equals(((Person) obj).lastName)) {
				return false;
			}else if(!this.firstName.equals(((Person) obj).firstName)) {
				return false;
			}else if(!this.emailAddress.equals(((Person) obj).emailAddress)) {
				return false;
			}else if(!this.userName.equals(((Person) obj).userName)) {
				return false;
			}else if(this.numFriends != ((Person) obj).numFriends) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	@Override
	/**
	 * Override hashCode method from Java Object
	 */
	public int hashCode() {
		int hashCode = 0;
		//Compute hashCode
		if(lastName != null && firstName != null && emailAddress != null && userName != null) {
			hashCode += 13 * lastName.hashCode();
			hashCode += 17 * firstName.hashCode();
			hashCode += 29 * emailAddress.hashCode();
			hashCode += 7 * userName.hashCode();
		}
		hashCode += 27 * numFriends;
		
		//Return computed hash code
		return hashCode;
	}
	

	
}
