package ch11;

import java.util.*;
import java.util.Map.Entry;

public class Exam5 {
	static HashMap phoneBook = new HashMap();

	public static void main(String[] args) {

		addPhoneNo("ģ��", "���ڹ�", "010-111-1111");
		addPhoneNo("ģ��", "���ڹ�", "010-222-2222");
		addPhoneNo("ģ��", "���ڹ�", "010-333-3333");
		addPhoneNo("ȸ��", "��븮", "010-444-4444");
		addPhoneNo("ȸ��", "��븮", "010-555-5555");
		addPhoneNo("ȸ��", "�ڴ븮", "010-666-6666");
		addPhoneNo("ȸ��", "�̰���", "010-777-7777");
		addPhoneNo("��Ź", "010-888-8888");

		printList();
	}

	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName);
		group.put(tel, name); // ��ȭ��ȣ-key, �̸�-value
	}

	static void addPhoneNo(String name, String tel) {
		addPhoneNo("��Ÿ", name, tel);
	}

	static void addGroup(String groupName) {
		if (!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap());
		}
	}

	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Entry) it.next();	// e: element
			Set subSet =  ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			System.out.println(" * " + e.getKey() + "[" + subSet.size()+"]");
			
			
			while (subIt.hasNext()) {
				Map.Entry subE = (Entry) subIt.next();
				String telNo = (String) subE.getKey();
				String name = (String) subE.getValue();
				System.out.println(name + " " + telNo);
						
			}
			
		}
		
	}

}