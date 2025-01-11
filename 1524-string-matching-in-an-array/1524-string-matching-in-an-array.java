class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}

/* 


["mass", "as", "hero", "superhero"]

Execution Steps:
Sort Words:
Sorted order: ["superhero", "hero", "mass", "as"].

Nested Comparison:

Compare "superhero" with:
"hero": Match! Add "hero" to results.
"mass": No match.
"as": No Match.
Compare "hero" with:
"mass": No match.
"as": No match.
Compare "mass" with:
"as": Match! Add "as" to results.
"as" has no shorter words to compare.
Results Before Deduplication:
["hero", "as"].

Remove Duplicates:
After deduplication: ["as", "hero"].

Output:
["as", "hero"]



*/