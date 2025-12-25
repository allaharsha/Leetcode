class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums = sorted(nums)
        print(nums)
        result = []
        handled = set()
        for i in range(1, len(nums)):
            if nums[i - 1] in handled:
                continue
            two_sums = self.twoSum(nums[i:], nums[i - 1] * -1)
            handled.add(nums[i - 1])
            for two_sum in two_sums:
                result.append([nums[i - 1]] + two_sum)

        return result

    def twoSum(self, nums: List[int], total: int) -> List[List[int]]:
        result = []
        handled = set()
        if len(nums) == 1:
            return result
        for i in range(1, len(nums)):
            if nums[i - 1] in handled:
                continue
            if (total - nums[i - 1]) in nums[i:]:
                result.append([nums[i - 1], total - nums[i - 1]])
            handled.add(nums[i - 1])
        return result
