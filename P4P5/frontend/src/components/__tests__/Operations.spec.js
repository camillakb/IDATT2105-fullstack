import { describe, it, expect, vitest, vi } from 'vitest'
import { createTestingPinia } from '@pinia/testing'
import { mount } from '@vue/test-utils'
import Operations from "../Operations.vue"
import {useDisplayContentStore} from "@/stores/displayContent";

describe("Operations", () => {
    it("renders properly", () => {
        const operations = mount(Operations, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })]
            }
        })

        //testing the accepted values
        expect(operations.text()).toContain("+")
        expect(operations.text()).toContain("-")
        expect(operations.text()).toContain("*")
        expect(operations.text()).toContain("/")
        expect(operations.text()).toContain("=")
        expect(operations.text()).toContain("AC")
        expect(operations.text()).toContain("DEL")

        //testing not accepted values
        expect(operations.text()).not.toBe("2")
        expect(operations.text()).not.toBe("hei")
    })

    it("insert() is called when a button is clicked", () => {
        const operations = mount(Operations, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })],
            },
        })

        const store = useDisplayContentStore()
        const confirmSpy = vi.spyOn(store, "insert")

        operations.find("button").trigger("click")
        expect(confirmSpy).toHaveBeenCalled()
    })
})