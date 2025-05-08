# SPDX-FileCopyrightText: Copyright (c) 2020 Aibolit
# SPDX-License-Identifier: MIT

import os
from unittest import TestCase
from aibolit.metrics.loc.loc import Loc


class LocTest(TestCase):
    def test_it_works(self):
        m = Loc(os.path.dirname(os.path.realpath(__file__)) + '/sample-1.java')
        loc = m.value()
        self.assertEqual(loc, 5)
