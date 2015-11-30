package pahinave.algorithms.applications;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCode<T> {
	public class TreeNode implements Comparable<TreeNode> {
		T tag;
		double freq;
		TreeNode left;
		TreeNode right;

		public TreeNode(T tag, double freq) {
			this(tag, freq, null, null);
		}

		public TreeNode(T tag, double freq, TreeNode left, TreeNode right) {
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

		public TreeNode getLeft() {
			return left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "FValue [tag=" + tag + ", freq=" + freq + "]";
		}

		@Override
		public int compareTo(HuffmanCode<T>.TreeNode o) {
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
		Queue<TreeNode> tree = new PriorityQueue<>();
		for (Entry<T, Double> entry : freqCount.entrySet()) {
			tree.add(new TreeNode(entry.getKey(), entry.getValue()));
		}

		while (tree.size() > 1) {
			TreeNode l = tree.remove();
			TreeNode r = tree.remove();
			tree.add(new TreeNode(null, l.getFreq() + r.getFreq(), l, r));
		}

		Map<T, String> codeMap = assignCode(tree.remove());
		return codeMap;
	}

	public Map<T, String> assignCode(TreeNode node) {
		Map<T, String> codeMap = new HashMap<>();
		assignCode(node, codeMap, "");
		return codeMap;
	}

	private void assignCode(HuffmanCode<T>.TreeNode node, Map<T, String> codeMap, String parentCode) {
		if (node.getLeft() == null && node.getRight() == null) {
			codeMap.put(node.getTag(), parentCode);
			return;
		}

		assignCode(node.getLeft(), codeMap, parentCode + "0");
		assignCode(node.getRight(), codeMap, parentCode + "1");
	}

	public TreeNode getCodeTree(Map<T, String> codeMap) {
		TreeNode root = new TreeNode(null, 0);
		for (Entry<T, String> codeEntry : codeMap.entrySet()) {
			T tag = codeEntry.getKey();
			String code = codeEntry.getValue();
			TreeNode current = root;
			for (int i = 0; i < code.length() - 1; i++) {
				if (code.charAt(i) == '0') {
					if (current.getLeft() == null) {
						current.setLeft(new TreeNode(null, 0));
					}
					current = current.getLeft();
				} else {
					if (current.getRight() == null) {
						current.setRight(new TreeNode(null, 0));
					}
					current = current.getRight();
				}
			}
			if (code.charAt(code.length() - 1) == '0') {
				current.setLeft(new TreeNode(tag, 0));
			} else {
				current.setRight(new TreeNode(tag, 0));
			}
		}

		return root;
	}

	public void decode(Map<T, String> codeMap, String encodedMsg, T[] message) {

		int msgIndex = 0;
		TreeNode root = getCodeTree(codeMap);
		TreeNode current = root;
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
