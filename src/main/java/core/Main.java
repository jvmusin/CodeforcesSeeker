//package core;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        AVLTree tree = new AVLTree();
//        int j = in.nextInt();
//        int a[] = new int[j];
//        for (int i = 0; i < j; i++)
//            a[i] = in.nextInt();
//
//        for (int k : a) {
//            tree.add(k);
//        }
//        tree.print(tree.root);
//    }
//
//    private static class AVLTree {
//        private TreeElem root;
//
//        public void add(int a) {
//            if (root == null) {
//                root = new TreeElem(a);
//                return;
//            }
//            TreeElem placed = findplace(a, root, null);
//            setBal(placed, placed.father);
//        }
//
//        private TreeElem findplace(int a, TreeElem elem, TreeElem pred) {
//            if (elem == null) {
//                elem = new TreeElem(a);
//                if (a > pred.val)
//                    pred.right = elem;
//                else if (a < pred.val)
//                    pred.left = elem;
//                elem.father = pred;
//                return elem;
//            }
//            if (elem.val > a) {
//                return findplace(a, elem.left, elem);
//            } else if (elem.val < a) {
//                return findplace(a, elem.right, elem);
//            } else System.out.println("Element already exist");
//            return elem;
//        }
//
//        public void print(TreeElem elem) {
//            System.out.print(elem.val + " ");
//            if (elem.left != null)
//                print(elem.left);
//            if (elem.right != null)
//                print(elem.right);
//        }
//
//        private void setBal(TreeElem elem, TreeElem father) {
//            if (father == null)
//                return;
//            if (father.right == elem) {
//                father.bal++;
//            } else {
//                father.bal--;
//            }
//
//            if (father.bal != 0 && (father.bal == 1 || father.bal == -1)) {
//                setBal(father, father.father);
//            } else {
//                if (father.bal == 2 && elem.bal == 1) {
//                    if (father == root)
//                        root = elem;
//                    father.right = elem.left;
//                    if (father.right != null)
//                        father.right.father = father;
//                    elem.left = father;
//                    elem.father = father.father;
//                    father.father = elem;
//                    if (elem.father != null)
//                        if (elem.father.right == father)
//                            elem.father.right = elem;
//                        else elem.father.left = elem;
//                    elem.bal = 0;
//                    father.bal = 0;
//                } else if (father.bal == -2 && elem.bal == -1) {
//                    if (father == root)
//                        root = elem;
//                    father.left = elem.right;
//                    if (father.left != null)
//                        father.left.father = father;
//                    elem.right = father;
//                    elem.father = father.father;
//                    father.father = elem;
//                    if (elem.father != null)
//                        if (elem.father.right == father)
//                            elem.father.right = elem;
//                        else elem.father.left = elem;
//                    elem.bal = 0;
//                    father.bal = 0;
//                } else if (father.bal == 2 && elem.bal == -1) {
//                    TreeElem third = elem.left;
//                    if (father == root)
//                        root = third;
//                    int k = third.bal;
//                    third.father = father.father;
//                    if (father.father != null) {
//                        if (father.father.right == father)
//                            father.father.right = third;
//                        else father.father.left = third;
//                    }
//
//                    father.right = third.left;
//                    if (father.right != null)
//                        father.right.father = father;
//                    elem.left = third.right;
//                    if (elem.left != null)
//                        elem.left.father = elem;
//                    third.left = father;
//                    third.right = elem;
//                    elem.father = third;
//                    father.father = third;
//
//                    if (k == -1) {
//                        father.bal = 0;
//                        third.bal = 0;
//                        elem.bal = 1;
//                    } else if (k == 1) {
//                        father.bal = -1;
//                        third.bal = 0;
//                        elem.bal = 0;
//                    }
//                } else if (father.bal == -2 && elem.bal == 1) {
//                    TreeElem third = elem.right;
//                    if (father == root)
//                        root = third;
//                    int k = third.bal;
//                    third.father = father.father;
//                    if (father.father != null) {
//                        if (father.father.right == father)
//                            father.father.right = third;
//                        else father.father.left = third;
//                    }
//
//                    father.left = third.right;
//                    if (father.left != null)
//                        father.left.father = father;
//                    elem.right = third.left;
//                    if (elem.right != null)
//                        elem.right.father = elem;
//                    third.right = father;
//                    third.left = elem;
//                    elem.father = third;
//                    father.father = third;
//
//                    if (k == -1) {
//                        father.bal = 1;
//                        third.bal = 0;
//                        elem.bal = 0;
//                    } else if (k == 1) {
//                        father.bal = 0;
//                        third.bal = 0;
//                        elem.bal = -1;
//                    }
//                }
//            }
//        }
//    }
//
//    private static class TreeElem {
//        private int val, bal;
//        private TreeElem left, right, father;
//
//        public TreeElem(int a) {
//            val = a;
//        }
//    }
//}
//
//
//
