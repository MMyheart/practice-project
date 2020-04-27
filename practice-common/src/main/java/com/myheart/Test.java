package com.myheart;


import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangxin
 * @date 2019/12/16
 */
public class Test {

    private static String s2;

    private static long rootSum = 0;
    private static long ans = 0;


    public static void main(String[] args) {
//        List<Integer> ans = findDisappearedNumbers(nums);
//        System.out.println(ans);
//        List<Byte> ans = printBinaryTree(5, (byte)0);
//        System.out.println(ans);
//        int[] candidates = new int[]{7,3,2};
//        int target = 18;
//        System.out.println(combinationSum(candidates, target));

//        int[] nums = new int[]{1,1,3,4};
//        System.out.println(permuteUnique(nums));
//
//        List<String>[] gardens = new LinkedList[10];
//        for(int i = 0; i < 10; i++){
//            gardens[i] = new LinkedList<>();
//            gardens[i].add("test"+i);
//
//        }
//        for(int i = 0; i < 10; i++){
//            System.out.println(gardens[i]);
//        }

//
//        ThreadTest threadTest0 = new ThreadTest("threadTest0");
//        ThreadTest threadTest1 = new ThreadTest("threadTest1");
//        ThreadTest threadTest2 = new ThreadTest("threadTest2");
//        ThreadTest threadTest3 = new ThreadTest("threadTest3");
//        ThreadTest threadTest4 = new ThreadTest("threadTest4");
//        threadTest0.start();
//        threadTest1.start();
//        threadTest2.start();
//        threadTest3.start();
//        threadTest4.start();
//
//        try {
//            Field f = threadTest0.getClass().getField("tid");
//            f.setAccessible(true);
//            System.out.println(f.get(threadTest0));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        TreeNode root = new TreeNode(1);
//        TreeNode root1 = new TreeNode(2);
//        TreeNode root2 = new TreeNode(3);
//        TreeNode root3 = new TreeNode(4);
//        TreeNode root4 = new TreeNode(5);
//        TreeNode root5 = new TreeNode(6);
//
//        root.left = root1;
//        root.right = root2;
//
//        root1.left = root3;
//        root1.right = root4;
//
//        root2.left = root5;
//
//        int a = maxProduct(root);
//        System.out.println(a);

//        String s = s2;
//       int[] nums = new int[]{1,3};
//       int target = 0;
//       System.out.println(search(nums, target));

        try {
            Class clazz = Thread.currentThread().getContextClassLoader().loadClass("com.myheart.Container");
            Field field = clazz.getDeclaredField("value");
            System.out.println(Container.value);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }


    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) /2;
            if(nums[mid] == target){
                return mid;
            }
            if(left == mid){
                left = mid + 1;
                continue;
            }
            if(nums[left] < nums[mid] && nums[left] <= target && target < nums[mid]){
                right = mid - 1;
                continue;
            }else if(nums[left] < nums[mid] && (nums[left] > target || target > nums[mid])){
                left = mid + 1;
                continue;
            }else if(nums[left] > nums[mid] && nums[mid] < target && target <= nums[right]){
                left = mid + 1;
                continue;
            }else if(nums[left] > nums[mid] && (nums[mid] > target || target > nums[right])){
                right = mid - 1;
                continue;
            }
        }
        if(left == right && nums[left] == target){
            return left;
        }
        return -1;
    }


    public static int maxProduct(TreeNode root) {
        calRootsum(root);
        calChildTreeMaxSum(root);
        return (int)(ans);
    }

    public static long calChildTreeMaxSum(TreeNode root){
        long left = 0;
        long right = 0;
        if(root.left != null){
            left = calChildTreeMaxSum(root.left);
        }
        if(root.right != null){
            right = calChildTreeMaxSum(root.right);
        }
        long result = left + right + root.val;
        left = left * (rootSum - left);
        right = right * (rootSum - right);
        ans = ans > left ? ans : left;
        ans = ans > right ? ans : right;
        return result;
    }

    public static void calRootsum(TreeNode root){
        if(root.left != null){
            calRootsum(root.left);
        }
        if(root.right != null){
            calRootsum(root.right);
        }
        rootSum += root.val;
    }

    static class ThreadTest extends Thread {

        public ThreadTest(String name){
            super(name);
        }

        static HashMap<Integer, Integer> map = new HashMap<>(2);
        static AtomicInteger at = new AtomicInteger();

        @Override
        public void run() {
            while (at.get() < 10000000) {
                map.put(at.get(), at.get());
                at.incrementAndGet();
            }
        }
    }

    public static TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode ans = null;
        TreeNode pos = new TreeNode(0);
        while (!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top.left != null && !visited.contains(top.left)){
                stack.push(top.left);
                continue;
            }
            // 处理
            stack.pop();
            visited.add(top);
            if(ans == null){
                ans = top;
            }
            pos.right = top;
            top.left = null;
            pos = top;
            if(top.right != null && !visited.contains(top.right)){
                stack.push(top.right);
            }
        }
        return ans;

    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numList = new LinkedList<>();
        Set<Integer> exsit = new HashSet<>();
        List<List<Integer>> ans = new LinkedList<>();
        if(nums.length == 0){
            return ans;
        }
        for(int i = 0; i < nums.length; i++){
            numList.add(nums[i]);
        }
        if(nums.length == 1){
            ans.add(numList);
            return ans;
        }

        for(int i = 0; i < nums.length; i++){
            if(exsit.contains(nums[i])){
                continue;
            }
            List<Integer> candidates = new LinkedList<>(numList);
            candidates.remove((Object)nums[i]);
            List<List<Integer>> anyAns = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            temp.add(nums[i]);
            anyAns.add(temp);

            permuteUnique(anyAns, candidates);
            ans.addAll(anyAns);
            exsit.add(nums[i]);
        }
        return ans;
    }

    public static void permuteUnique(List<List<Integer>> anyAns, List<Integer> candidates){
        if(candidates.size() == 1){
            anyAns.get(0).add(candidates.get(0));
            return;
        }
        List<Integer> top = anyAns.get(0);
        anyAns.clear();
        Set<Integer> exsit = new HashSet<>();
        for(int i = 0; i < candidates.size(); i++){
            Integer candidate = candidates.get(i);
            if(exsit.contains(candidate)){
                continue;
            }
            candidates.remove(i);
            List<List<Integer>> ans = new LinkedList<>();
            List<Integer> oneAns = new LinkedList<>();

            oneAns.addAll(top);
            oneAns.add(candidate);
            ans.add(oneAns);
            permuteUnique(ans, candidates);

            anyAns.addAll(ans);
            candidates.add(i, candidate);
            exsit.add(candidate);
        }

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        boolean[] candidatesSorted = new boolean[target+1];
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] > target){
                continue;
            }
            candidatesSorted[candidates[i]] = true;
        }
        Map<Integer, List<List<Integer>>> combinationMap = new HashMap<>();
        for(int i = 1; i < target; i++){
            List<List<Integer>> combinationList = new LinkedList<>();
            if(candidatesSorted[i]){
                List<Integer> selfList = new LinkedList<>();
                selfList.add(i);
                combinationList.add(selfList);
            }
            for(int j = 1; j <= i/2; j++){
                if(!candidatesSorted[j]){
                    continue;
                }
                if(combinationMap.get(j) != null && combinationMap.get(i-j) != null){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(j);
                    temp.add(i-j);
                    combinationList.add(temp);
                }
            }
            if (!combinationList.isEmpty()){
                combinationMap.put(i, combinationList);
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        if (candidatesSorted[target]){
            List<Integer> selfList = new LinkedList<>();
            selfList.add(target);
            ans.add(selfList);
        }
        candidatesSorted = new boolean[target+1];

        for(int i = 1; i <= (target-1)/2; i++){
            if(combinationMap.get(i)!=null && combinationMap.get(target-i)!=null){
                List<List<Integer>> smallerList = combinationMap.get(i);
                if (!candidatesSorted[i]){
//                    expandList(smallerList, combinationMap, candidatesSorted);
                    candidatesSorted[i] = true;
                }
                List<List<Integer>> largerList = combinationMap.get(target-i);
                if (!candidatesSorted[target-i]){
                    expandList(largerList, combinationMap, candidatesSorted);
                    candidatesSorted[target-i] = true;
                }
                for (List<Integer> small : smallerList){
                    for (List<Integer> larger : largerList){
                        if (larger.get(0) < i){
                            continue;
                        }
                        List<Integer> temp = new LinkedList<>();
                        temp.addAll(small);
                        temp.addAll(larger);
                        ans.add(temp);
                    }
                }
            }
        }
        if (target % 2 == 0 && combinationMap.get(target/2) != null){
            List<List<Integer>> largerList = combinationMap.get(target/2);
            if (!candidatesSorted[target/2]){
                expandList(largerList, combinationMap, candidatesSorted);
            }
            for (List<Integer> larger : largerList){
                if (larger.get(0) < target/2){
                    continue;
                }
                List<Integer> temp = new LinkedList<>();
                temp.add(target/2);
                temp.addAll(larger);
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void expandList(List<List<Integer>> candidateList, Map<Integer, List<List<Integer>>> combinationMap, boolean[] candidatesSorted){
        if (candidateList.size() == 1 && candidateList.get(0).size() == 1){
            return;
        }
        List<List<Integer>> expand = new LinkedList<>();
        for (List<Integer> candidates : candidateList){
            if(candidates.size() == 1){
                expand.add(candidates);
                continue;
            }
            List<List<Integer>> temp1 = combinationMap.get(candidates.get(0));
            if(!candidatesSorted[candidates.get(0)]){
//                expandList(temp1 , combinationMap, candidatesSorted);
                candidatesSorted[candidates.get(0)] = true;
            }
            List<List<Integer>> temp2 = combinationMap.get(candidates.get(1));
            if(!candidatesSorted[candidates.get(1)]){
                expandList(temp2 , combinationMap, candidatesSorted);
                candidatesSorted[candidates.get(1)] = true;
            }
            for (List<Integer> small : temp1) {
                for (List<Integer> larger : temp2) {
                    if (larger.get(0) < candidates.get(0)){
                        continue;
                    }
                    List<Integer> temp = new LinkedList<>();
                    temp.addAll(small);
                    temp.addAll(larger);
                    expand.add(temp);
                }

            }
        }
        candidateList.clear();
        candidateList.addAll(expand);
    }


    public static int maximumSum(int[] arr) {
        int pre = 0;
        int after = 0;

        int preNegativeIndex = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                preNegativeIndex = i;
                break;
            }
            pre += arr[i];
        }
        if(preNegativeIndex < 0){
            return pre;
        }
        if(preNegativeIndex == 0){
            pre = arr[0];
        }
        int ans = pre;
        for(int i = preNegativeIndex+1; i < arr.length; i++){
            if(arr[i] >= 0){
                after += arr[i];
                continue;
            }
            int temp;
            if(preNegativeIndex + 1 == i){
                if(pre < 0){
                    temp = arr[preNegativeIndex];
                } else{
                    temp = pre;
                }
                pre = arr[i];
            } else{
                if(pre < 0){
                    temp = after;
                } else{
                    temp = pre + after;
                }
                pre = after;
            }
            ans = ans > temp ? ans : temp;

            preNegativeIndex = i;
            after = 0;
        }
        int temp;
        if(arr[arr.length-1] < 0){
            if(pre < 0){
                temp = arr[preNegativeIndex];
            } else{
                temp = pre;
            }
        } else{
            if(pre < 0){
                temp = after;
            } else{
                temp = pre + after;
            }
        }
        ans = ans > temp ? ans : temp;
        return ans;
    }


    public static int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int ans1 = rob(nums, 0, nums.length-1);
        int ans2 = rob(nums, 1, nums.length);
        return Math.max(ans1, ans2);
    }

    public static int rob(int[] nums, int start, int end){

        int ans = 0;
        int p1 = nums[start];
        int p2 = 0;
        for(int i = start+2; i <= end; i++){
            ans = Math.max(p1, p2+nums[i-1]);
            p2 = p1;
            p1 = ans;
        }
        return ans;
    }




}

