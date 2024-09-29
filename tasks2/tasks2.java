public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println(DuplicateChars.duplicateChars("Barack", "Obama")); 

        // 2
        System.out.println(DividedByThree.dividedByThree(new int[]{3, 12, 7, 81, 52})); 

        // 3
        System.out.println(GetInitials.getInitials("simonov sergei evgenievich")); 
        System.out.println(GetInitials.getInitials("kozhevnikova tatiana vitalevna")); 

        // 4
        System.out.println(java.util.Arrays.toString(Normalizator.normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5}))); 

        // 5
        System.out.println(java.util.Arrays.toString(CompressedNums.compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5}))); 

        // 6
        System.out.println(CamelToSnake.camelToSnake("helloWorld")); 

        // 7
        System.out.println(SecondBiggest.secondBiggest(new int[]{3, 5, 8, 1, 2, 4})); 

        // 8
        System.out.println(LocalReverse.localReverse("baobab", 'b')); 
        System.out.println(LocalReverse.localReverse("Hello, I’m under the water, please help me", 'e')); 

        // 9
        System.out.println(Equal.equal(8, 1, 8)); 
        System.out.println(Equal.equal(5, 5, 5));
        System.out.println(Equal.equal(4, 9, 6));

        // 10
        System.out.println(IsAnagram.isAnagram("LISTEN", "silent"));
        System.out.println(IsAnagram.isAnagram("Eleven plus two?", "Twelve plus one!")); 
        System.out.println(IsAnagram.isAnagram("hello", "world")); 
    }
}

class DuplicateChars {
    public static String duplicateChars(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (!str2.contains(String.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }
}

class DividedByThree {
    public static int dividedByThree(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 3 == 0 && num % 2 != 0) {
                count++;
            }
        }
        return count;
    }
}

class GetInitials {
    public static String getInitials(String fullName) {
        String[] parts = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (int i = 0; i < parts.length - 1; i++) {
            initials.append(Character.toUpperCase(parts[i].charAt(0))).append(".");
        }
        initials.append(Character.toUpperCase(parts[parts.length - 1].charAt(0)))
                .append(parts[parts.length - 1].substring(1));
        return initials.toString();
    }
}

class Normalizator {
    public static double[] normalizator(double[] arr) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : arr) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        if (min == max) {
            return new double[arr.length];  
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (arr[i] - min) / (max - min);
        }
        return result;
    }
}

class CompressedNums {
    public static int[] compressedNums(double[] arr) {
        java.util.ArrayList<Integer> resultList = new java.util.ArrayList<>();
        for (double num : arr) {
            if (num != 0) {
                resultList.add((int) Math.round(num));
            }
        }
        resultList.sort(Integer::compareTo);
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}

class CamelToSnake {
    public static String camelToSnake(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append("_").append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

class SecondBiggest {
    public static int secondBiggest(int[] arr) {
        java.util.Set<Integer> uniqueNums = new java.util.TreeSet<>();
        for (int num : arr) {
            uniqueNums.add(num);
        }
        Integer[] sortedNums = uniqueNums.toArray(new Integer[0]);
        return sortedNums.length >= 2 ? sortedNums[sortedNums.length - 2] : -1;
    }
}

class LocalReverse {
    public static String localReverse(String str, char marker) {
        int start = str.indexOf(marker);
        int end = str.lastIndexOf(marker);
        if (start != -1 && end != -1 && start != end) {
            StringBuilder middle = new StringBuilder(str.substring(start + 1, end));
            return str.substring(0, start + 1) + middle.reverse() + str.substring(end);
        }
        return str;
    }
}

class Equal {
    public static int equal(int a, int b, int c) {
        if (a == b && b == c) {
            return 3;
        } else if (a == b || a == c || b == c) {
            return 2;
        }
        return 0;
    }
}

class IsAnagram {
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return java.util.Arrays.equals(arr1, arr2);
    }
}
