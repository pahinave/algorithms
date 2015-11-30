package pahinave.algorithms.applications.tests;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.applications.HuffmanCode;

public class HuffmanCodeTest {
	@Test
	public void testSampleEnglishText() throws Exception {
		HuffmanCode<Character> hc = new HuffmanCode<>();

		String trainingMessage = "During the period 2000-500 BCE, in terms of culture, many regions of the subcontinent transitioned from the Chalcolithic to the Iron Age.[36] The Vedas, the oldest scriptures of Hinduism,[37] were composed during this period,[38] and historians have analysed these to posit a Vedic culture in the Punjab region and the upper Gangetic Plain.[36] Most historians also consider this period to have encompassed several waves of Indo-Aryan migration into the subcontinent.[39][37] The caste system arose during this period, which created a hierarchy of priests, warriors, free peasants and traders, and lastly the indigenous peoples who were regarded as impure; and small tribal units gradually coalesced into monarchical, state-level polities.[40][41] On the Deccan Plateau, archaeological evidence from this period suggests the existence of a chiefdom stage of political organisation.[36] In southern India, a progression to sedentary life is indicated by the large number of megalithic monuments dating from this period,[42] as well as by nearby traces of agriculture, irrigation tanks, and craft traditions.[42]";

		Character[] trainingMessageChars = convertToCharacterArray(trainingMessage);

		Map<Character, String> codeMap = hc.genCode(trainingMessageChars);

		// sample message
		String sampleMessage1 = "in terms of culture, many regions of the subcontinent transitioned from the Chalcolithic to the Iron Age.[36] The Vedas, the oldest scriptures of Hinduism,[37] were composed during this period,[38] and historians have analysed these to posit a Vedic culture in the Punjab region and the upper Gangetic Plain.[36] Most historians also consider th";
		Character[] sampleMessageChars1 = convertToCharacterArray(sampleMessage1);
		String encodedMsg1 = hc.encode(sampleMessageChars1, codeMap);
		Character[] sampleMessage1DecodedChars = new Character[sampleMessage1.length()];
		hc.decode(codeMap, encodedMsg1, sampleMessage1DecodedChars);
		Assert.assertArrayEquals(sampleMessageChars1, sampleMessage1DecodedChars);

		// sample message
		String sampleMessage2 = "lysed these to posit a Vedic culture in the Punjab region and the upper Gangetic Plain.[36] Most historians also consider this period to have encompassed several waves of Indo-Aryan migration into the subcontinent.[39][37] The caste system arose during this period, which created a hierarchy of priests, warriors, free peasants and traders, and lastly the indigenous peoples who were regarded as impure; and small tribal units gradually coalesced into monarchical, state-level polities.[40][41] On the Deccan Plateau, archaeological evidence from this period suggests the existence of a chiefdom stage of political organisation.[36] In southern India, a progression to sedentary life is indicated by the large number of megalithic monuments dating from this period,[42] as well as by nearby traces of agriculture, irrigation tanks, and craft traditions.[42]";
		Character[] sampleMessageChars2 = convertToCharacterArray(sampleMessage2);
		String encodedMsg2 = hc.encode(sampleMessageChars2, codeMap);
		Character[] sampleMessage2DecodedChars = new Character[sampleMessage2.length()];
		hc.decode(codeMap, encodedMsg2, sampleMessage2DecodedChars);
		Assert.assertArrayEquals(sampleMessageChars2, sampleMessage2DecodedChars);
	}

	@Test
	public void testTwoLengthString() throws Exception {
		HuffmanCode<Character> hc = new HuffmanCode<>();

		String trainingMessage = "ab";

		Character[] trainingMessageChars = convertToCharacterArray(trainingMessage);

		Map<Character, String> codeMap = hc.genCode(trainingMessageChars);

		// sample message
		String sampleMessage1 = "ababababbbabbbaaabbaaa";
		Character[] sampleMessageChars1 = convertToCharacterArray(sampleMessage1);
		String encodedMsg1 = hc.encode(sampleMessageChars1, codeMap);
		Character[] sampleMessage1DecodedChars = new Character[sampleMessage1.length()];
		hc.decode(codeMap, encodedMsg1, sampleMessage1DecodedChars);
		Assert.assertArrayEquals(sampleMessageChars1, sampleMessage1DecodedChars);

		// sample message
		String sampleMessage2 = "bababababababababababaaaaabbbbbaaaaa";
		Character[] sampleMessageChars2 = convertToCharacterArray(sampleMessage2);
		String encodedMsg2 = hc.encode(sampleMessageChars2, codeMap);
		Character[] sampleMessage2DecodedChars = new Character[sampleMessage2.length()];
		hc.decode(codeMap, encodedMsg2, sampleMessage2DecodedChars);
		Assert.assertArrayEquals(sampleMessageChars2, sampleMessage2DecodedChars);

	}

	private Character[] convertToCharacterArray(String message) {
		Character[] msgChars = new Character[message.length()];
		for (int i = 0; i < message.length(); i++) {
			msgChars[i] = message.charAt(i);
		}
		return msgChars;
	}
}
