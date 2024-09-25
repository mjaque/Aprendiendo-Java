package academia19e37;

public class UsoHashTable {

	public static void main(String[] args) {
		
		int N = 11;	//size of the hash list
		
		HashTable hashTable = new HashTable(N);

		//init the hash list
		//NodoHashTable[] hashList = 	initHashList(N);

		//entries to insert into the has list
		String keys[] = {"Hund","Katze","Maus","Schlange","Pferd"};
		int values[] = {1,2,3,4,5};
		int K = 5;

		for(int i=0;i<K;i++){
			//insert(hashList,N,keys[i],values[i]);
			if (hashTable.insert(keys[i], values[i]))
				System.out.println(keys[i] + " insertado");
			else
				System.out.println(keys[i] + " no Insertado");
		}

		//plot hash list
		//dump(hashList, N);
		hashTable.dump();
/*
		//entries which should be removed from the hash list
		std::string rkeys[] = {"Maus","Schlange"};
		int rK = 2;

		//removes values from the hash list
		for(int i=0;i<rK;i++){
			remove(hashList,N,rkeys[i]);
		}

		//plot the hash list
		dump(hashList, N);

		//get an element of the list
		int value = get(hashList,N,"Pferd");
		std::cout << std::endl;
		std::cout << "Pferd: " << value << std::endl;
*/
		//TODO: free the hash list
		/* your code */
		

	}

}
