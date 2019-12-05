package Olatunde_Emmanuel_Beeck_Derrek_Bland_Elijah_Navas_Edwin;

public interface HashComparator<K> {
	public int hashIndex(K k);
	public Boolean keyEqual(K k1, K k2);
}
