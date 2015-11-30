package pahinave.algorithms.applications;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCode<T> {
	public class FValue implements Comparable<FValue> {
		T tag;
		double freq;
		FValue left;
		FValue right;

		public FValue(T tag, double freq) {
			this(tag, freq, null, null);
		}

		public FValue(T tag, double freq, FValue left, FValue right) {
			super();
			this.tag = tag;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		public T getTag() {
			return tag;
		}

		public void setTag(T tag) {
			this.tag = tag;
		}

		public double getFreq() {
			return freq;
		}

		public void setFreq(double freq) {
			this.freq = freq;
		}

		public FValue getLeft() {
			return left;
		}

		public FValue getRight() {
			return right;
		}

		public void setLeft(FValue left) {
			this.left = left;
		}

		public void setRight(FValue right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "FValue [tag=" + tag + ", freq=" + freq + "]";
		}

		@Override
		public int compareTo(HuffmanCode<T>.FValue o) {
			if (freq < o.getFreq())
				return -1;
			else if (freq > o.getFreq())
				return 1;
			else
				return 0;
		}

	}

	public Map<T, String> genCode(T[] input) {
		HashMap<T, Integer> tCount = new HashMap<>();
		for (T t : input) {
			Integer oldValue = tCount.computeIfAbsent(t, k -> Integer.valueOf(0));
			tCount.put(t, oldValue + 1);
		}

		HashMap<T, Double> freqCount = new HashMap<>();

		for (Entry<T, Integer> entry : tCount.entrySet()) {
			freqCount.put(entry.getKey(), (double) entry.getValue() / Double.valueOf(input.length));
		}

		return genCode(freqCount);
	}

	public String encode(T[] input, Map<T, String> codeMap) {
		StringBuilder sb = new StringBuilder();
		for (T next : input) {
			sb.append(codeMap.get(next));
		}
		return sb.toString();
	}

	public Map<T, String> genCode(HashMap<T, Double> freqCount) {
		Queue<FValue> tree = new PriorityQueue<>();
		for (Entry<T, Double> entry : freqCount.entrySet()) {
			tree.add(new FValue(entry.getKey(), entry.getValue()));
		}

		while (tree.size() > 1) {
			FValue l = tree.remove();
			FValue r = tree.remove();
			tree.add(new FValue(null, l.getFreq() + r.getFreq(), l, r));
		}

		Map<T, String> codeMap = assignCode(tree.remove());
		return codeMap;
	}

	public Map<T, String> assignCode(FValue node) {
		Map<T, String> codeMap = new HashMap<>();
		assignCode(node, codeMap, "");
		return codeMap;
	}

	private void assignCode(HuffmanCode<T>.FValue node, Map<T, String> codeMap, String parentCode) {
		if (node.getLeft() == null && node.getRight() == null) {
			codeMap.put(node.getTag(), parentCode);
			return;
		}

		assignCode(node.getLeft(), codeMap, parentCode + "0");
		assignCode(node.getRight(), codeMap, parentCode + "1");
	}

	public FValue getCodeTree(Map<T, String> codeMap) {
		FValue root = new FValue(null, 0);
		for (Entry<T, String> codeEntry : codeMap.entrySet()) {
			T tag = codeEntry.getKey();
			String code = codeEntry.getValue();
			FValue current = root;
			for (int i = 0; i < code.length() - 1; i++) {
				if (code.charAt(i) == '0') {
					if (current.getLeft() == null) {
						current.setLeft(new FValue(null, 0));
					}
					current = current.getLeft();
				} else {
					if (current.getRight() == null) {
						current.setRight(new FValue(null, 0));
					}
					current = current.getRight();
				}
			}
			if (code.charAt(code.length() - 1) == '0') {
				current.setLeft(new FValue(tag, 0));
			} else {
				current.setRight(new FValue(tag, 0));
			}
		}

		return root;
	}

	public void decode(Map<T, String> codeMap, String encodedMsg, T[] message) {

		int msgIndex = 0;
		FValue root = getCodeTree(codeMap);
		FValue current = root;
		for (int i = 0; i < encodedMsg.length(); i++) {
			switch (encodedMsg.charAt(i)) {
			case '0':
				current = current.getLeft();
				break;
			case '1':
				current = current.getRight();
				break;
			}
			if (current.getTag() != null) {
				message[msgIndex++] = current.getTag();
				current = root;
			}
		}
	}

}
