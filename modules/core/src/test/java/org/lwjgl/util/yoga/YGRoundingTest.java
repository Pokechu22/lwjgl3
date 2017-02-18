/*
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package org.lwjgl.util.yoga;

import org.testng.annotations.Test;

import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YGRoundingTest {
	@Test
	public void test_rounding_flex_basis_flex_grow_row_width_of_100() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWidth(100f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(1f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(33f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(33f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(34f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(67f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(33f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(67f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(33f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(33f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(34f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(33f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_flex_basis_flex_grow_row_prime_number_width() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWidth(113f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(1f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setFlexGrow(1f);
		root.addChildAt(root_child3, 3);

		YogaNode root_child4 = new YogaNode();
		root_child4.setFlexGrow(1f);
		root.addChildAt(root_child4, 4);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(113f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(23f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(23f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(22f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(45f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(23f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(68f, root_child3.getLayoutX(), 0.0f);
		assertEquals(0f, root_child3.getLayoutY(), 0.0f);
		assertEquals(22f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(90f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(23f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child4.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(113f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(90f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(23f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(68f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(22f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(45f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(23f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(23f, root_child3.getLayoutX(), 0.0f);
		assertEquals(0f, root_child3.getLayoutY(), 0.0f);
		assertEquals(22f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(23f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child4.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_flex_basis_flex_shrink_row() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWidth(101f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexShrink(1f);
		root_child0.setFlexBasis(100f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexBasis(25f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexBasis(25f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(101f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(51f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(51f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(25f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(76f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(25f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(101f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(51f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(25f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(25f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(25f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_flex_basis_overrides_main_size() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setWidth(100f);
		root.setHeight(113f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(1f);
		root_child0.setFlexBasis(50f);
		root_child0.setHeight(20f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1f);
		root_child1.setHeight(10f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1f);
		root_child2.setHeight(10f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_total_fractial() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setWidth(87.4f);
		root.setHeight(113.4f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(0.7f);
		root_child0.setFlexBasis(50.3f);
		root_child0.setHeight(20.3f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1.6f);
		root_child1.setHeight(10f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1.1f);
		root_child2.setHeight(10.7f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(87f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(59f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(59f, root_child1.getLayoutY(), 0.0f);
		assertEquals(87f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(87f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(87f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(59f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(59f, root_child1.getLayoutY(), 0.0f);
		assertEquals(87f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(87f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_total_fractial_nested() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setWidth(87.4f);
		root.setHeight(113.4f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(0.7f);
		root_child0.setFlexBasis(50.3f);
		root_child0.setHeight(20.3f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child0_child0 = new YogaNode();
		root_child0_child0.setFlexGrow(1f);
		root_child0_child0.setFlexBasis(0.3f);
		root_child0_child0.setPosition(YogaEdge.BOTTOM, 13.3f);
		root_child0_child0.setHeight(9.9f);
		root_child0.addChildAt(root_child0_child0, 0);

		YogaNode root_child0_child1 = new YogaNode();
		root_child0_child1.setFlexGrow(4f);
		root_child0_child1.setFlexBasis(0.3f);
		root_child0_child1.setPosition(YogaEdge.TOP, 13.3f);
		root_child0_child1.setHeight(1.1f);
		root_child0.addChildAt(root_child0_child1, 1);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1.6f);
		root_child1.setHeight(10f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1.1f);
		root_child2.setHeight(10.7f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(87f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(59f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(-13f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(12f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(25f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(47f, root_child0_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(59f, root_child1.getLayoutY(), 0.0f);
		assertEquals(87f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(87f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(87f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(59f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(-13f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(12f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(25f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(87f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(47f, root_child0_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(59f, root_child1.getLayoutY(), 0.0f);
		assertEquals(87f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(87f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_fractial_input_1() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setWidth(100f);
		root.setHeight(113.4f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(1f);
		root_child0.setFlexBasis(50f);
		root_child0.setHeight(20f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1f);
		root_child1.setHeight(10f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1f);
		root_child2.setHeight(10f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_fractial_input_2() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setWidth(100f);
		root.setHeight(113.6f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(1f);
		root_child0.setFlexBasis(50f);
		root_child0.setHeight(20f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1f);
		root_child1.setHeight(10f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1f);
		root_child2.setHeight(10f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(114f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(65f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(65f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(114f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(65f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(65f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_fractial_input_3() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setPosition(YogaEdge.TOP, 0.3f);
		root.setWidth(100f);
		root.setHeight(113.4f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(1f);
		root_child0.setFlexBasis(50f);
		root_child0.setHeight(20f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1f);
		root_child1.setHeight(10f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1f);
		root_child2.setHeight(10f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(114f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(114f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

	@Test
	public void test_rounding_fractial_input_4() {
		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, true);

		YogaNode root = new YogaNode();
		root.setPosition(YogaEdge.TOP, 0.7f);
		root.setWidth(100f);
		root.setHeight(113.4f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexGrow(1f);
		root_child0.setFlexBasis(50f);
		root_child0.setHeight(20f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexGrow(1f);
		root_child1.setHeight(10f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setFlexGrow(1f);
		root_child2.setHeight(10f);
		root.addChildAt(root_child2, 2);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(1f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(1f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(113f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(64f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(64f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(89f, root_child2.getLayoutY(), 0.0f);
		assertEquals(100f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(24f, root_child2.getLayoutHeight(), 0.0f);

		YogaNode.setExperimentalFeatureEnabled(YogaExperimentalFeature.ROUNDING, false);
	}

}
