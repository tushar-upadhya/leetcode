const VOWELS = ["a", "e", "i", "o", "u"];

function countOfSubstrings(word: string, k: number): number {
    return atLeastK(word, k) - atLeastK(word, k + 1);
}

function atLeastK(word: string, k: number): number {
    const vowelSet = new Set(VOWELS);
    let vowelCount = new Map<string, number>();
    let consonants = 0;
    let validSubstrings = 0;
    let left = 0;

    for (let right = 0; right < word.length; right++) {
        const char = word[right];

        if (vowelSet.has(char)) {
            vowelCount.set(char, (vowelCount.get(char) || 0) + 1);
        } else {
            consonants++;
        }

        while (consonants >= k && vowelCount.size === 5) {
            validSubstrings += word.length - right;

            const leftChar = word[left];

            if (vowelSet.has(leftChar)) {
                vowelCount.set(leftChar, vowelCount.get(leftChar)! - 1);
                if (vowelCount.get(leftChar) === 0) {
                    vowelCount.delete(leftChar);
                }
            } else {
                consonants--;
            }

            left++;
        }
    }

    return validSubstrings;
}