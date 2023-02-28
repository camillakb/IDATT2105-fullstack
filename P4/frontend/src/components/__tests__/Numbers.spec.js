import { describe, it, expect, vitest, vi } from 'vitest'
import { mount } from '@vue/test-utils'
import { createTestingPinia } from '@pinia/testing'
import Numbers from "../Numbers.vue"
import {useDisplayContentStore} from "@/stores/displayContent";

describe("Numbers", () => {
    it ("renders properly", () => {
        const numbers = mount(Numbers, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })]
            }
        })

        //testing the accepted values
        expect(numbers.text()).toContain("1")
        expect(numbers.text()).toContain("2")
        expect(numbers.text()).toContain("3")
        expect(numbers.text()).toContain("4")
        expect(numbers.text()).toContain("5")
        expect(numbers.text()).toContain("6")
        expect(numbers.text()).toContain("7")
        expect(numbers.text()).toContain("8")
        expect(numbers.text()).toContain("9")
        expect(numbers.text()).toContain("0")
        expect(numbers.text()).toContain(".")

        //testing that letters are not accepted
        expect(numbers.text).not.toBe("hei")
        expect(numbers.text).not.toBe("+")
    })

    it ("insert() is called when a button is clicked", () => {
        const numbers = mount(Numbers, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })],
            },
        })

        const store = useDisplayContentStore()
        const confirmSpy = vi.spyOn(store, "insert")

        numbers.find("button").trigger("click")
        expect(confirmSpy).toHaveBeenCalled()
    })
})