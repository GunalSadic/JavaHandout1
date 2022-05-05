package ro.ase.acs.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Meeting implements Cloneable {
	private String name;
	private int startTime;
	private int endTime;
	private Priority priority;
	private String[] participants = null;
	public String[] getParticipants() {
		String[] participants = new String [this.participants.length];
		for(int i = 0 ; i < this.participants.length ; i++) {
			participants[i] = this.participants[i];
		}
		return participants;
	}
	public void setParticipants(String[] participants) {
		this.participants = new String [participants.length];
		for( int i = 0 ; i < participants.length; i++)
			this.participants[i] = participants[i];
	}
	public Meeting(String name, int startTime, int duration) {
		
		this.name = name;
		this.startTime = startTime;
		this.endTime = startTime + duration;
		priority = Priority.low;
	}
	
	public Meeting() {
		name = "";
		startTime = 0;
		endTime = 0;
		priority = Priority.low;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Meeting copy = (Meeting)super.clone();
		copy.endTime = endTime;
		copy.startTime = startTime;
		copy.name = new String(name);
		copy.priority = priority;
		copy.participants = new String[(participants.length)];
		for(int i = 0; i < participants.length; i++) {
			copy.participants[i] = participants[i];
		}
		return copy;
	}
	public void PrintInfo (){
		System.out.println(name);
		System.out.println(" ");
		System.out.println(startTime);
		System.out.println(" ");
		System.out.println(endTime);
		System.out.println(" ");
		System.out.println(priority);
		System.out.println("\n ");
		for (int i = 0 ;i<participants.length;i++) {
		System.out.println(participants[i]);
		System.out.println(" ");
		}}
	public boolean checkParticipant(String p) {
			for(int i = 0; i<participants.length;i++) {
				if(participants[i] == p )
					return true;
				}
			return false;
		}
	public void concatenate(Meeting m2) {
		this.name = this.name + "/" + m2.name;
		if(this.startTime > m2.startTime)
			this.startTime = m2.startTime;
		if(this.endTime<m2.endTime)
			this.endTime = m2.endTime;
		if((this.priority == Priority.low && (m2.priority == Priority.medium || m2.priority == Priority.high))
				|| this.priority == Priority.medium && m2.priority == Priority.high
				) {
			this.priority = m2.priority;
		}
		 Set<String> unionOfArrays = new HashSet<>();
		 unionOfArrays.addAll(Arrays.asList(this.participants));
		 unionOfArrays.addAll(Arrays.asList(m2.participants));
		 String[] unionArray = {};
	     this.participants = unionOfArrays.toArray(unionArray);
		 
		
		
	}
}
	

