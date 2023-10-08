class TimeMap {

    private HashMap<String , String> hashMap;
    private LinkedList<Integer> list;

    public TimeMap() {
        hashMap = new HashMap<>();
        list = new LinkedList<>();
    }

    public void set(String key, String value, int timestamp) {
        hashMap.put(timestamp + key , value);
        list.add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (hashMap.containsKey(timestamp+key)) {
            return hashMap.get(timestamp+key);
        }else {
            int length = list.size()-1;
            boolean cond = false;
            while (length >= 0 && !cond) {
                String str = list.get(length)+ key;
                cond = timestamp > list.get(length) && hashMap.containsKey(str);
                if (cond) {
                    return hashMap.get(str);
                }
                length--;
            }
        }
        return "";
    }
}
